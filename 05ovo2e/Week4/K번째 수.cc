#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>

using namespace std;


void qsort(vector<int> &arr, int start, int end) {

	if (start >= end) {
		return;
	}
	
	int pivot = arr[(start+end)/2];
	int l = start;
	int r = end;

	while (l <= r) {
		while (arr[l] < pivot) {
			l++;
		}
		while (arr[r] > pivot) {
			r--;
		}
		if (l <= r) { 
			swap(arr[l], arr[r]);
			l++;
			r--;
		
		}
	}
	qsort(arr, start, r);
	qsort(arr, l, end);

}

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> n >> k;
	cin.ignore(); // 남아있는 개행 문자를 무시

	string input; // 배열 한 문장으로 읽어오기
	getline(cin, input);

	istringstream iss(input);
	vector<int> numbers;
	int number;

	while (iss >> number) {
		numbers.push_back(number);
	}

	qsort(numbers, 0, n-1);
	cout << numbers[k-1];

	/*for (int i = 0; i < n; i++) {
		
	}*/
	
			
	return 0;
}

