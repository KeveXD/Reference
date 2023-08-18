using klitechHazi.Model;
using klitechHazi.View;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace klitechHazi
{
    public sealed partial class BookDetailsPage : Page
    {
        public BookDetailsPage()
        {
            this.InitializeComponent();
        }

        protected async override void OnNavigatedTo(NavigationEventArgs e)
        {
            base.OnNavigatedTo(e);

            // Az előző oldalról átvett könyv adatok lekérése
            Book selectedBook = (Book)e.Parameter;

            // Könyv részletek megjelenítése a felületen
            titleLabel.Text = "Címe: " + selectedBook.Name;
            authorLabel.Text = "Írója: " + string.Join(", ", selectedBook.Authors);
            // Egyéb könyv részletek megjelenítése itt

            // Példa más adatok megjelenítésére:
            isbnLabel.Text = "ISBN: " + selectedBook.Isbn;
            pagesLabel.Text = "Oldalszám: " + selectedBook.NumberOfPages.ToString();
            publisherLabel.Text = "Kiadó: " + selectedBook.Publisher;
            countryLabel.Text = "Ország: " + selectedBook.Country;
            mediaTypeLabel.Text = "Média típusa: " + selectedBook.MediaType;
            releasedLabel.Text = "Megjelenés dátuma: " + selectedBook.Released.ToString();

            // Karakterek betöltése és megjelenítése
            IceAndFireApi api = new IceAndFireApi();
            ObservableCollection<Character> characters = await api.GetCharactersAsyncC();

            charactersListBox.ItemsSource = characters.Where(c => selectedBook.Characters.Contains(c.Url));
            povCharactersListBox.ItemsSource = characters.Where(c => selectedBook.PovCharacters.Contains(c.Url));
        }



        private void BackButton_Click(object sender, RoutedEventArgs e)
        {
            Frame.GoBack();
        }

        private void Character_Click(object sender, RoutedEventArgs e)
        {
            Button characterButton = (Button)sender;
            Character selectedCharacter = (Character)characterButton.DataContext;

            // Átirányítás a CharacterReszletek oldalra
            Frame.Navigate(typeof(CharacterDetailsPage), selectedCharacter.Url);
        }
    }
}
