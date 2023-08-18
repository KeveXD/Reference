using System;
using System.Collections.Generic;
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
using klitechHazi.Model;
using System.Threading.Tasks;

namespace klitechHazi.View
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class CharacterDetailsPage : Page
    {
        private IceAndFireApi _api = new IceAndFireApi();

        public CharacterDetailsPage()
        {
            this.InitializeComponent();
        }

        protected override async void OnNavigatedTo(NavigationEventArgs e)
        {
            base.OnNavigatedTo(e);

            // Az előző oldalról átvett karakter nevének lekérése
            string characterName = e.Parameter as string;

            // Karakter részletek lekérése a nevével alapján
            Character selectedCharacter = await _api.GetCharacterAsync(characterName);

            // Ha a karakter található, beállítjuk DataContext-nek
            if (selectedCharacter != null)
            {
                DataContext = selectedCharacter;

                // Címek ListBox feltöltése
                titlesListBox.ItemsSource = selectedCharacter.Titles;

                // Aliasok ListBox feltöltése
                aliasesListBox.ItemsSource = selectedCharacter.Aliases;

                // Hűbérúri kötelezettségek ListBox feltöltése
                allegiancesListBox.ItemsSource = await GetCharacterNames(selectedCharacter.Allegiances);

                // Könyvek ListBox feltöltése
                booksListBox.ItemsSource = await GetBookNames(selectedCharacter.Books);

                // POV könyvek ListBox feltöltése
                povBooksListBox.ItemsSource = await GetBookNames(selectedCharacter.PovBooks);

                // TV sorozatok ListBox feltöltése
                tvSeriesListBox.ItemsSource = selectedCharacter.TvSeries;

                // Eljátszotta ListBox feltöltése
                playedByListBox.ItemsSource = selectedCharacter.PlayedBy;
            }
        }

        private async Task<List<string>> GetCharacterNames(List<string> characterUrls)
        {
            List<string> characterNames = new List<string>();

            foreach (string url in characterUrls)
            {
                Character character = await _api.GetCharacterAsync(url);
                if (character != null)
                {
                    characterNames.Add(character.Name);
                }
            }

            return characterNames;
        }

        private async Task<List<string>> GetBookNames(List<string> bookUrls)
        {
            List<string> bookNames = new List<string>();

            foreach (string url in bookUrls)
            {
                Book book = await _api.GetBookAsync(url);
                if (book != null)
                {
                    bookNames.Add(book.Name);
                }
            }

            return bookNames;
        }

        private void BackButton_Click(object sender, RoutedEventArgs e)
        {
            // Visszatérés a korábbi oldalra
            if (Frame.CanGoBack)
            {
                Frame.GoBack();
            }
        }

        private void SomeButton_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
