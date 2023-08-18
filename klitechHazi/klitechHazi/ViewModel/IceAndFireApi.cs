using klitechHazi.Model;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace klitechHazi
{
    internal class IceAndFireApi
    {
        private const string BaseUrl = "https://www.anapioficeandfire.com/api/";
        private HttpClient _httpClient = new HttpClient();

        public async Task<ObservableCollection<Book>> GetBooksAsync()
        {
            string url = $"{BaseUrl}books";
            HttpResponseMessage response = await _httpClient.GetAsync(url);

            if (response.IsSuccessStatusCode)
            {
                string json = await response.Content.ReadAsStringAsync();
                ObservableCollection<Book> books = JsonConvert.DeserializeObject<ObservableCollection<Book>>(json);
                return books;
            }

            return null;
        }

        public async Task<Character> GetCharacterAsync(string characterName)
        {
            string url = characterName; // Az adott karakter URL-je

            HttpResponseMessage response = await _httpClient.GetAsync(url);

            if (response.IsSuccessStatusCode)
            {
                string json = await response.Content.ReadAsStringAsync();
                Character character = JsonConvert.DeserializeObject<Character>(json);

                if (character != null)
                {
                    return character;
                }
            }

            throw new Exception("Karakter nem található."); // Kivétel dobása, ha nem található karakter
        }


        public async Task<List<string>> GetCharactersBySearchAsync(string searchTerm)
        {
            string url = $"{BaseUrl}characters?pageSize=50";
            List<string> characterUris = new List<string>();

            while (!string.IsNullOrEmpty(url))
            {
                HttpResponseMessage response = await _httpClient.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    string json = await response.Content.ReadAsStringAsync();
                    List<Character> characters = JsonConvert.DeserializeObject<List<Character>>(json);

                    if (characters != null)
                    {
                        List<Character> filteredCharacters = characters.Where(c => c.Name.Equals(searchTerm)).ToList();

                        List<string> filteredCharacterUris = filteredCharacters.Select(c => c.Url).ToList();
                        characterUris.AddRange(filteredCharacterUris);

                        // Ellenőrizzük, hogy van-e további oldal az eredményekben
                        IEnumerable<string> linkHeaders = response.Headers.GetValues("Link");
                        url = GetNextPageUrlFromLinkHeaders(linkHeaders);
                    }
                    else
                    {
                        url = null;
                    }
                }
                else
                {
                    url = null;
                }
            }

            if (characterUris.Any())
            {
                return characterUris;
            }

            throw new Exception("Nem sikerült lekérni a karaktereket.");
        }

        private string GetNextPageUrlFromLinkHeaders(IEnumerable<string> linkHeaders)
        {
            foreach (string linkHeader in linkHeaders)
            {
                string[] links = linkHeader.Split(',');

                foreach (string link in links)
                {
                    string[] parts = link.Split(';');

                    if (parts.Length == 2 && parts[1].Trim() == "rel=\"next\"")
                    {
                        string url = parts[0].Trim();

                        if (url.StartsWith("<") && url.EndsWith(">"))
                        {
                            return url.Substring(1, url.Length - 2);
                        }
                    }
                }
            }

            return null;
        }


        public async Task<List<string>> GetCharactersAsync()
        {
            string url = $"{BaseUrl}characters?pageSize=50";
            List<string> characterNames = new List<string>();

            while (!string.IsNullOrEmpty(url))
            {
                HttpResponseMessage response = await _httpClient.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    string json = await response.Content.ReadAsStringAsync();
                    List<Character> characters = JsonConvert.DeserializeObject<List<Character>>(json);

                    if (characters != null)
                    {
                        List<string> characterNamesOnPage = characters.Select(c => c.Name).ToList();
                        characterNames.AddRange(characterNamesOnPage);

                        // Ellenőrizzük, hogy van-e további oldal az eredményekben
                        IEnumerable<string> linkHeaders = response.Headers.GetValues("Link");
                        url = GetNextPageUrlFromLinkHeaders(linkHeaders);
                    }
                    else
                    {
                        url = null;
                    }
                }
                else
                {
                    url = null;
                }
            }

            if (characterNames.Any())
            {
                return characterNames;
            }

            throw new Exception("Nem sikerült lekérni a karaktereket.");
        }


        public async Task<ObservableCollection<House>> GetHousesAsync()
        {
            string url = $"{BaseUrl}houses?pageSize=50";
            List<string> houseUris = new List<string>();

            while (!string.IsNullOrEmpty(url))
            {
                HttpResponseMessage response = await _httpClient.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    string json = await response.Content.ReadAsStringAsync();
                    List<House> houses = JsonConvert.DeserializeObject<List<House>>(json);

                    if (houses != null)
                    {
                        List<string> houseUrisOnPage = houses.Select(h => h.Url).ToList();
                        houseUris.AddRange(houseUrisOnPage);

                        // Check if there is another page in the results
                        IEnumerable<string> linkHeaders = response.Headers.GetValues("Link");
                        url = GetNextPageUrlFromLinkHeaders(linkHeaders);
                    }
                    else
                    {
                        url = null;
                    }
                }
                else
                {
                    url = null;
                }
            }

            if (houseUris.Count > 0)
            {
                ObservableCollection<House> houses = new ObservableCollection<House>();
                foreach (string houseUri in houseUris)
                {
                    HttpResponseMessage houseResponse = await _httpClient.GetAsync(houseUri);
                    if (houseResponse.IsSuccessStatusCode)
                    {
                        string houseJson = await houseResponse.Content.ReadAsStringAsync();
                        House house = JsonConvert.DeserializeObject<House>(houseJson);
                        houses.Add(house);
                    }
                }
                return houses;
            }

            throw new Exception("Failed to retrieve houses.");
        }

        public async Task<ObservableCollection<Character>> GetCharactersAsyncC()
        {
            string url = $"{BaseUrl}characters?pageSize=50";
            ObservableCollection<Character> characters = new ObservableCollection<Character>();

            while (!string.IsNullOrEmpty(url))
            {
                HttpResponseMessage response = await _httpClient.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    string json = await response.Content.ReadAsStringAsync();
                    ObservableCollection<Character> charactersOnPage = JsonConvert.DeserializeObject<ObservableCollection<Character>>(json);

                    if (charactersOnPage != null)
                    {
                        foreach (Character character in charactersOnPage)
                        {
                            characters.Add(character);
                        }

                        // Ellenőrizzük, hogy van-e további oldal az eredményekben
                        IEnumerable<string> linkHeaders = response.Headers.GetValues("Link");
                        url = GetNextPageUrlFromLinkHeaders(linkHeaders);
                    }
                    else
                    {
                        url = null;
                    }
                }
                else
                {
                    url = null;
                }
            }

            if (characters.Any())
            {
                return characters;
            }

            throw new Exception("Nem sikerült lekérni a karaktereket.");
        }




        public async Task<Book> GetBookAsync(string bookUrl)
        {
            HttpResponseMessage response = await _httpClient.GetAsync(bookUrl);

            if (response.IsSuccessStatusCode)
            {
                string json = await response.Content.ReadAsStringAsync();
                Book book = JsonConvert.DeserializeObject<Book>(json);
                return book;
            }

            return null;
        }
    }
}
