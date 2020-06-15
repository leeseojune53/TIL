using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;

public class Mathematics
{
    delegate int CalcDelegate(int x, int y);
    static int Add(int x, int y) { return x + y; }
    static int Subtract(int x, int y) { return x - y; }
    static int Multiply(int x, int y) { return x * y; }
    static int Divied(int x, int y) { return x / y; }


    CalcDelegate[] methods;
    public Mathematics()
    {
        methods = new CalcDelegate[] { Mathematics.Add, Mathematics.Subtract, Mathematics.Multiply, Mathematics.Divied };
    }
    
    public void Calculate(char opCode, int operand1, int operand2)
    {
        switch (opCode)
        {
            case '+':
                Console.WriteLine("+: " + methods[0](operand1, operand2));
                break;
            case '-':
                Console.WriteLine("-: " + methods[1](operand1, operand2));
                break;
            case '*':
                Console.WriteLine("*: " + methods[2](operand1, operand2));
                break;
            case '/':
                Console.WriteLine("/: " + methods[3](operand1, operand2));
                break;

        }
    }

 }

namespace Delegate
{

    
    class Program
    {
        delegate void WorkDelegate(char arg1, int arg2, int arg3);
        static void Main(string[] args)
        {
            Mathematics math = new Mathematics();
            WorkDelegate work = math.Calculate;

            work('+', 10, 5);
            work('-', 10, 5);
            work('*', 10, 5);
            work('/', 10, 5);
        }
    }
}
