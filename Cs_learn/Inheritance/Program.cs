using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Inheritance
{
    public class Computer
    {
        protected bool powerOn;
        public void Boot() { }
        public void Shutdown() { }
        public void Reset() { }

    }

    public class Notebook : Computer
    {
        bool fingerScan;
        public bool HasFingerScanDevice() { return fingerScan; }

        public void CloseLid()
        {
            if (powerOn == true)
            {
                Shutdown();
            }
        }
    }

    public class Desktop : Computer
    {

    }

    public class Netbook : Computer
    {

    }

    class Program
    {
        static void Main(string[] args)
        {
            Computer com = new Computer();
            
        }
    }
}
