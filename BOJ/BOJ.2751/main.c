#include <stdio.h>
#include <stdlib.h>


void Sort(int* Arr, int left, int mid, int right, int* Buf_Arr)
{
	int i, j, k;

	i = left;
	j = mid + 1;
	k = left;
	while (i <= mid && j <= right) {
		if (Arr[i] <= Arr[j])
			Buf_Arr[k++] = Arr[i++];
		else Buf_Arr[k++] = Arr[j++];
	}
	if (i > mid) {
		for (int l = j; l <= right; l++) {
			Buf_Arr[k++] = Arr[l];
		}
	}
	else {
		for (int l = i; l <= mid; l++) {
			Buf_Arr[k++] = Arr[l];
		}
	}

	for (int l = left; l <= right; l++) {
		Arr[l] = Buf_Arr[l];
	}

}

void Marge(int* Arr, int left, int right, int* Buf_Arr)
{
	int mid;

	if (left < right) {
		mid = (left + right) / 2;
		Marge(Arr, left, mid, Buf_Arr);
		Marge(Arr, mid + 1, right, Buf_Arr);
		Sort(Arr, left, mid, right, Buf_Arr);
	}
}

int main()
{
	int n;
	int* In_Arr;
	int* Buf_Arr;

	scanf("%d", &n);

	In_Arr = (int*)malloc(sizeof(int) * n);
	Buf_Arr = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &In_Arr[i]);
	}

	Marge(In_Arr, 0, n - 1, Buf_Arr);

	for (int i = 0; i < n; i++) {
		printf("%d\n", In_Arr[i]);
	}

	return 0;
}
