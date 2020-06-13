using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Circle
{
    class Circle
    {
        double pi = 3.14;
        int radius;
        double GetArea(double radius)
        {
            return radius * radius;
        }
        public double Pi
        {
            get { return pi; }
            set { pi = value; }
        }
        public double Get_Area
        {
            get { return radius * radius * pi; }
            set { radius = (int)value; }
        }
        
    }
    class Program
    {
        static void Main(string[] args)
        {
            Circle o = new Circle();
            o.Pi = 3.141592;
            double piValue = o.Pi;
            Console.WriteLine(piValue);
            o.Get_Area = 5;
            double Area_Value = o.Get_Area;
            Console.WriteLine(Area_Value);
        }
    }
}
