using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication4
{
    class IntStream
    {
        private int number;
        public IntStream()
        {
            reset();
        }
        public int next()
        {
            return number++;
        }
        public bool eos()
        {
            if (number >= int.MaxValue)
                return true;
            else return false;
        }
        public void reset()
        {
            number = 0;
        }
    }
    class PrimeStream : IntStream
    {
        int primeNr;
        bool findPrim;
        bool eosState;
        public PrimeStream()
        {
            primeNr = 2;
            eosState = false;
        }
        public int next()
        {
            int prevPrimeNr = primeNr;
            for (int i = prevPrimeNr + 1; i <= int.MaxValue; i++)
            {
                findPrim = true;
                for (int j = 2; j < i; j++)
                {
                    if (i % j == 0)
                    {
                        findPrim = false;
                        break;
                    }

                }
                if (findPrim)
                {
                    primeNr = i;
                    break;
                }
            }
            if (primeNr > int.MaxValue)
                eosState = true;
            return prevPrimeNr;
        }
        public bool eos()
        {
            return eosState;
        }
        public void reset()
        {
            primeNr = 2;
            eosState = false;
        }
    }
    class RandomStream : IntStream
    {
        Random rand = new Random();
        int randNum;
        public RandomStream()
        {
            randNum = rand.Next();
        }
        public int next(int a, int b)
        {
            return rand.Next(a, b);
        }
        public bool eos()
        {
            return false;
        }
    }
    class RandomWordStream
    {
        string slowo;
        int prime;
        int random;
        RandomStream rand = new RandomStream();
        PrimeStream pierwsza = new PrimeStream();
        public RandomWordStream()
        {
            slowo = "";
            prime = pierwsza.next();
            random = rand.next(97, 122);            
        }
        public string next()
        {
            slowo = "";
            for (int i = 1; i <= prime; i++)
            {
                slowo = slowo + (char)random;
                random = rand.next(97, 122);
            }
            prime = pierwsza.next();
            return slowo;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            IntStream objekt = new IntStream();
            RandomWordStream word = new RandomWordStream();
            Console.WriteLine(objekt.next());
            Console.WriteLine(objekt.next());
            Console.WriteLine(objekt.next());
            RandomStream obj = new RandomStream();
            Console.WriteLine("");
            for (int i = 1; i <= 25; i++)
            {
                Console.Write((char)obj.next(97, 122));
            }
            Console.WriteLine();
            for (int i = 1; i <= 10; i++)
            {
                Console.WriteLine(word.next());
            }
                Console.Read();
        }
    }
}
