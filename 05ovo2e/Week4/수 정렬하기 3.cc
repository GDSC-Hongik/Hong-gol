#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>

using namespace std;

int arr[10001] = { 0 };

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore(); // 남아있는 개행 문자를 무시

	for (int i = 1; i < n+1; i++) {
		int input;
		cin >> input;
		arr[input]++;
	}

	
	for (int i = 1; i < 10001; i++) {
		if (arr[i] != 0) {
			for (int j = 0; j < arr[i]; j++) {
				cout << i << "\n";
			}
			
		}
		// cout << i << "번째 값: " << arr[i] << "\n";
	}

	return 0;
	
}