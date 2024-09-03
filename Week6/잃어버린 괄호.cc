#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>
#include <cctype>

using namespace std;

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string input;

	vector<int> numbers;
	vector<char> op;

	string currentNumber;
	string letters;

	getline(cin, input);

	for (char ch : input) {
		if (isdigit(ch)) {
			currentNumber += ch;
		}
		else {
			if (!currentNumber.empty()) {
				numbers.push_back(stoi(currentNumber));
				currentNumber.clear();
			}
			if (ch == '+' || ch == '-') {
				op.push_back(ch);
			}
		}
	}

	if (!currentNumber.empty()) {
		numbers.push_back(stoi(currentNumber));
	}

	int result = numbers[0];
	bool minus = false; // 기본은 +

	// - 연산자가 등장 시점부터 수식의 나머지 부분을 최대한 많이 뺄셈으로 처리
	for (int i = 0; i < op.size(); i++) {
		if (op[i] == '-') {
			minus = true;
		}
		
		if (minus) {
			result -= numbers[i + 1];
		}
		else {
			result += numbers[i + 1];
		}
	}

	cout << result << "";

	return 0;

}