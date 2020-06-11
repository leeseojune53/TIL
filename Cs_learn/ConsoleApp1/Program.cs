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
            public static int x = 1;
        }
        static void Main(string[] args)
        {
            d D = new d();
            Console.WriteLine("Hell world");
            Console.WriteLine(d.x);
        }
    }
}
