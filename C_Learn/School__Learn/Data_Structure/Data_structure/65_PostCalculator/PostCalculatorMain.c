#include <stdio.h>
#include "PostCalculator.h"
#include "../64_InfixToPostfix/InfixToPostfix.h"
#include "../63_ListBaseStack/ListBaseStack.h"

int main(void)
{
	char buf[256];
	while (1) {
		gets(buf);
		if (!buf)
			break;
		ConvToRPNExp(buf);
		printf("%d\n", EvalRPNExp(buf));
	}
	

	return 0;
}