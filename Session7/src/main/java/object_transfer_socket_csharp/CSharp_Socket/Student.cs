using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace CSharp_Socket
{
    [Serializable]
    class Student
    {
        [JsonProperty("id")] 
        public int Id { get; set; }
        [JsonProperty("name")] 
        public String Name { get; set; }


    }
}
