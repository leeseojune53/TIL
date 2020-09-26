#include <stdio.h>

int main()
{
	int count[26] = { 0, };
	int max_cnt = 0;
	int max_pos;
	int max = 0;

	char input_data;


	while (1) {
		scanf("%c", &input_data);
		if(input_data == '\n')
            break;
		if ('a' <= input_data && input_data <= 'z')
			++count[input_data - 97];
		else if ('A' <= input_data && input_data <= 'Z')
			++count[input_data - 65];
	}

	for (int i = 0; i < 26; i++) {
		if (count[i] > max) {
			max_cnt = 1;
			max_pos = i;
			max = count[i];
		}
		else if (count[i] == max) {
			++max_cnt;
		}
	}

	if (max_cnt >= 2)
		printf("?");
	else printf("%c", max_pos + 65);

}
