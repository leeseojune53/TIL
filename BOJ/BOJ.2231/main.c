#include <stdio.h>
#include <math.h>

int main()
{
	int input, buf, buff;
	int constructor = 0;

	scanf("%d", &input);

	for (int i = input / 2; i < input; i++) {
		buf = i;
		buff = i;
		while (buf > 0) {
			buff += buf % 10;
			buf /= 10;
		}
		if (input == buff) {
			constructor = i;
			break;
		}

	}
	printf("%d", constructor);

	return 0;
}
