using System;
using System.Collections.Generic;

namespace klitechHazi.Model
{
    public class Book
    {
        public string Name { get; set; }
        public string Isbn { get; set; }
        public List<string> Authors { get; set; }
        public int NumberOfPages { get; set; }
        public string Publisher { get; set; }
        public string Country { get; set; }
        public string MediaType { get; set; }
        public DateTime Released { get; set; }
        public List<string> Characters { get; set; }
        public List<string> PovCharacters { get; set; }
    }
}
