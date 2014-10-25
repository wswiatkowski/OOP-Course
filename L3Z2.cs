using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Slownik
    {
        public List<string> keyList = new List<string>();
        public List<string> valueList = new List<string>();             
        
        public void Add(string k, string v)
        {                         
            keyList.Add(k);
            valueList.Add(v);
        }

        public string Return(string k)
        {
            int id = 0;
            foreach(string element in keyList)
            {
                if (element == k)
                {
                    return valueList[id];
                }
                id++;
            }           
            return "error";          
      
        }
        public void Remove(string k)
        {
            int id = 0;
            foreach (string element in keyList)
            {
                if (element == k)
                {
                    valueList.Remove(valueList[id]);
                    keyList.Remove(k);
                    break;
                }
                id++;
            }
        }

        
    }
        
    class Program
    {
        static void Main(string[] args)
        {
            
            Slownik mySlownik = new Slownik();
            for (int i = 0; i <= 2; i++)
            {
                mySlownik.Add(Console.ReadLine(), Console.ReadLine());
                
            }

            for (int i = 0; i <= 2; i++)
            {
                string ky = Console.ReadLine();
                Console.WriteLine(mySlownik.Return(ky));
            }


                Console.ReadKey();

        }
    }
}
