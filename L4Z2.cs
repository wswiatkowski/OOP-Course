using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{

    public class Buffer<T>
    {
        public int i;
        public T[] myArray;
        public uint size;
        public Buffer(uint arraySize)
        {
            myArray = new T[arraySize];
            i = 0;
            size = arraySize;
            
        }
        public static bool operator +(Buffer<T> x, T y)
        {
            if (x.i >= x.size-1)
            {
                return false;
            }
            else
            {
                x.myArray[x.i] = y;
                x.i++;
                return true;
            }

            
        }
        public T Pop{
            get
            {
                if (this.i == 0)
                {
                    throw new Exception("ListEmpty");
                }
                else
                {

                    T ret = this.myArray[0];
                    for (int a = 0; a < this.i; a++)
                    {
                        this.myArray[a] = this.myArray[a + 1];
                    }
                    this.myArray[this.i] = default(T);
                    this.i--;
                    return ret;
                }
            }
            
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Buffer<int> myBuffer = new Buffer<int>(1000);
            bool x;
            /*for (int i = 0; i <= 1111; i++){
                x = myBuffer + i;
                Console.WriteLine(x);
            }*/

            for (int i = 0; i <= 4; i++)
            {
                try
                {
                    Console.WriteLine(myBuffer.Pop);
                }
                catch(Exception Ex)
                {
                    Console.WriteLine(Ex);
                }
                
            }
            Console.ReadKey();
        }
    }
}
