#include <iostream>
#include <vector>

using namespace std;

class Complex {
		double real, imag;
	public:
		int value1 = 5;
		Complex(double r = 0, double i = 0) :real(r), imag(i) {}
		void print() {
			cout << real << " " << imag;
		}
};

int main()
{
	Complex Com;
	int& ref = Com.value1;
	ref=6;
	
	return 0;
}
