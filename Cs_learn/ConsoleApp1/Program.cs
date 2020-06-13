using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        private struct d
        {
            public int x;
        }
        static void Main(string[] args)
        {
            d D = new d();
            D.x = 1;
            Console.WriteLine("Hell world");
            Console.WriteLine(D.x);
        }
    }
}
