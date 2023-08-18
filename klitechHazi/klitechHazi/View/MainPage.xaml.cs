using klitechHazi.Model;
using klitechHazi.View;
using klitechHazi.ViewModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Threading.Tasks;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace klitechHazi
{
    public sealed partial class MainPage : Page
    {
        public MainPageViewModel ViewModel { get; set; }

        public MainPage()
        {
            this.InitializeComponent();
            ViewModel = new MainPageViewModel();
            DataContext = ViewModel;
        }

        private async void SearchButton_Click(object sender, RoutedEventArgs e)
        {
            string searchTerm = SearchTextBox.Text.Trim();

            if (!string.IsNullOrEmpty(searchTerm))
            {
                await ViewModel.SaveSearchTermAsync(searchTerm);
                await ViewModel.PerformSearch(searchTerm);
            }
        }

        private async void BooksListButton_Click(object sender, RoutedEventArgs e)
        {
            await ViewModel.LoadBooksAsync();
        }

        private async void HousesListButton_Click(object sender, RoutedEventArgs e)
        {
            await ViewModel.LoadHousesAsync();
        }

        private async void CharactersListButton_Click(object sender, RoutedEventArgs e)
        {
            await ViewModel.LoadCharactersAsync();
        }

        private void BookButtonClick(object sender, RoutedEventArgs e)
        {
            Button detailsButton = (Button)sender;
            Book selectedBook = (Book)detailsButton.DataContext;
            Frame.Navigate(typeof(BookDetailsPage), selectedBook);
        }

        private void CharacterButton_Click(object sender, RoutedEventArgs e)
        {
            Button characterButton = (Button)sender;
            Character selectedCharacter = (Character)characterButton.DataContext;
            Frame.Navigate(typeof(CharacterDetailsPage), selectedCharacter.Url);
        }

        private async void Page_Loaded(object sender, RoutedEventArgs e)
        {
            await ViewModel.DisplayDataAsync();
            await ViewModel.InitializeSearchTermAsync();
        }
    }
}
