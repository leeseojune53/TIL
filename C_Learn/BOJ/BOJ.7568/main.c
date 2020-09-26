#include <stdio.h>

int main()
{
	int n;
	int people[50][50];
	int Rank[50] = { 0, };
	int chk;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &people[i][0], &people[i][1]);
	}

	for (int i = 0; i < n; i++) {
		chk = 0;
		for (int j = 0; j < n; j++) {
			if (people[i][0] < people[j][0] && people[i][1] < people[j][1])
				++Rank[i];
		}
	}

	for (int i = 0; i < n; i++) {
		printf("%d ", Rank[i] + 1);
	}

	return 0;
}
