#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>

using namespace std;

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n; // 총 배열 길이
	cin.ignore(); // 남아있는 개행 문자를 무f시
	string input; // 배열 한 문장으로 읽어오기
	getline(cin, input);

	istringstream iss(input);
	vector<int> numbers;
	
	string token;

	while (iss >> token) {
		// 문자열을 숫자로 변환
		int number = stoi(token);
		numbers.push_back(number);
	}

	for (int j = 1; j < numbers.size(); j++) {
		int num = numbers[j];
		numbers.erase(numbers.begin() + j);
		auto it = lower_bound(numbers.begin(), numbers.begin() + j, num);
		numbers.insert(it, num);

	}
	vector<int> partial(numbers.size(), 0);

	/*for (int i = 0; i < numbers.size(); i++) {
		cout << numbers[i] << " ";
	}
	cout << "\n";*/

	partial[0] = numbers[0];
	int sum = partial[0];

	for (int i = 1; i < numbers.size(); i++) {
		partial[i] = numbers[i] + partial[i - 1];
		/*cout << i << "인 경우: " << partial[i] << "\n";*/
		sum += partial[i];
	}

	/*for (int i = 0; i < numbers.size(); i++) {
		cout << partial[i] << '\n';
	}
	*/
	cout << sum << '\n';
			
	return 0;
}

