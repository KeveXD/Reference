using klitechHazi.Model;
using System;
using System.Collections.ObjectModel;
using System.IO;
using System.Threading.Tasks;
using Windows.Storage;
using Windows.UI.Xaml.Controls;

namespace klitechHazi.ViewModel
{
    public class MainPageViewModel
    {
        public ObservableCollection<Book> Books { get; set; }
        public ObservableCollection<Character> Characters { get; set; }
        public ObservableCollection<House> Houses { get; set; }
        private bool booksLoaded = false;
        private bool housesLoaded = false;
        private bool charactersLoaded = false;
        private const string SearchTermFileName = "SearchTerm.txt";

        public MainPageViewModel()
        {
            Books = new ObservableCollection<Book>();
            Characters = new ObservableCollection<Character>();
            Houses = new ObservableCollection<House>();
        }

        public async Task LoadBooksAsync()
        {
            if (!booksLoaded)
            {
                IceAndFireApi api = new IceAndFireApi();
                ObservableCollection<Book> books = await api.GetBooksAsync();

                if (books != null)
                {
                    Books.Clear();
                    foreach (var book in books)
                    {
                        Books.Add(book);
                    }
                    booksLoaded = true;
                }
            }
        }

        public async Task LoadHousesAsync()
        {
            if (!housesLoaded)
            {
                IceAndFireApi api = new IceAndFireApi();
                ObservableCollection<House> houses = await api.GetHousesAsync();
                if (houses != null)
                {
                    Houses.Clear();
                    foreach (var house in houses)
                    {
                        Houses.Add(house);
                    }
                    housesLoaded = true;
                }
            }
        }

        public async Task LoadCharactersAsync()
        {
            if (!charactersLoaded)
            {
                IceAndFireApi api = new IceAndFireApi();
                ObservableCollection<Character> characters = await api.GetCharactersAsyncC();
                if (characters != null)
                {
                    Characters.Clear();
                    foreach (var character in characters)
                    {
                        Characters.Add(character);
                    }
                    charactersLoaded = true;
                }
            }
        }

        public async Task DisplayDataAsync()
        {
            await LoadBooksAsync();
            await LoadHousesAsync();
            await LoadCharactersAsync();
        }

        public void BookButtonClick(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            Button detailsButton = (Button)sender;
            Book selectedBook = (Book)detailsButton.DataContext;
            // Frame.Navigate(typeof(BookDetailsPage), selectedBook);
        }

        public void CharacterButton_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            Button characterButton = (Button)sender;
            Character selectedCharacter = (Character)characterButton.DataContext;
            // Frame.Navigate(typeof(CharacterDetailsPage), selectedCharacter.Url);
        }

        public async Task<string> LoadSearchTermAsync()
        {
            try
            {
                StorageFolder localFolder = ApplicationData.Current.LocalFolder;
                StorageFile file = await localFolder.GetFileAsync(SearchTermFileName);
                return await FileIO.ReadTextAsync(file);
            }
            catch (FileNotFoundException)
            {
                return string.Empty;
            }
        }

        public async Task SaveSearchTermAsync(string searchTerm)
        {
            StorageFolder localFolder = ApplicationData.Current.LocalFolder;
            StorageFile file = await localFolder.CreateFileAsync(SearchTermFileName, CreationCollisionOption.ReplaceExisting);
            await FileIO.WriteTextAsync(file, searchTerm);
        }

        public async Task<string> GetSavedSearchTermAsync()
        {
            string searchTerm = await LoadSearchTermAsync();
            if (!string.IsNullOrEmpty(searchTerm))
            {
                // SearchTextBox.Text = searchTerm;
            }
            return searchTerm;
        }

        public async Task InitializeSearchTermAsync()
        {
            string searchTerm = await GetSavedSearchTermAsync();
            if (!string.IsNullOrEmpty(searchTerm))
            {
                await PerformSearch(searchTerm);
            }
        }

        public async Task PerformSearch(string searchTerm)
        {
            IceAndFireApi api = new IceAndFireApi();
            // List<string> characters = await api.GetCharactersBySearchAsync(searchTerm);

            // if (characters != null && characters.Count > 0)
            // {
            //     string selectedCharacter = characters[0];
            //     // Frame.Navigate(typeof(CharacterDetailsPage), selectedCharacter);
            // }
            // else
            // {
            //     // Kezelés az adott visszajelzésnek vagy üzenetnek a felhasználónak, ha nem találtunk karaktereket.
            // }
        }

        public async void SearchButton_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            // string searchTerm = SearchTextBox.Text.Trim();

            // if (!string.IsNullOrEmpty(searchTerm))
            // {
            //     await SaveSearchTermAsync(searchTerm);
            //     await PerformSearch(searchTerm);
            // }
        }

        public void UpdateButtons()
        {
            // foreach (Button button in CharactersItemsControl.ItemsPanelRoot.Children)
            // {
            //     button.Content = "Karakterek";
            // }
        }

        public async void BooksListButton_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            await LoadBooksAsync();
        }

        public async void HousesListButton_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            await LoadHousesAsync();
        }

        public async void CharactersListButton_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            await LoadCharactersAsync();
        }

        public async void Page_Loaded(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            await DisplayDataAsync();
            await InitializeSearchTermAsync();
        }
    }
}
