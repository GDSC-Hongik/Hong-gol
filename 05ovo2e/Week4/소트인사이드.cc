#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>

using namespace std;


int main() {
	//std::ios::sync_with_stdio(false);
	//cin.tie(NULL);
	//cout.tie(NULL);
	//int n;
	//cin >> n;
	//cin.ignore(); // 남아있는 개행 문자를 무시


	string input;
	getline(cin, input);
	vector<int> numbers;

	for (char ch : input) {
		numbers.push_back(ch - '0'); // 문자를 숫자로 바꾸어 push
	}

	for (int i = 0; i < numbers.size(); i++) {
		auto max = max_element(numbers.begin()+i, numbers.end()); // + i해서 현재 배열 이후로 최대값 찾기
		swap(numbers[distance(numbers.begin(), max)], numbers[i]);
	}

	for (int num : numbers) {
		cout << num ;
	}

	return 0;
}

