using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace @interface
{
    class Program
    {
        abstract class DrawingObject
        {
            public abstract void Draw();
            public abstract void Move(int offset);
        }

        interface IDrawingObject
        {
            void Draw();
        }

        class Line : IDrawingObject
        {
            public void Draw() { Console.WriteLine("Line"); }
        }

        class Rectangle : IDrawingObject
        {
            public void Draw() { Console.WriteLine("Rectangle"); }
        }

        interface IMonitor
        {
            void TurnOn();
            int Inch { get; set; }
            int Width { get; }
        }

        class Notebook : IMonitor
        {
            public void TurnOn() { }

            int inch;
            public int Inch
            {
                get { return inch; }
                set { inch = value; }
            }

            int width;
            public int Width { get { return width; } }
        }

        static void Main(string[] args)
        {
            IDrawingObject[] instances = new IDrawingObject[] { new Line(), new Rectangle(), new Line()};

            foreach(IDrawingObject item in instances)
            {
                item.Draw();
            }
        }
    }
}
