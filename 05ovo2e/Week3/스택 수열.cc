#include <iostream>
#include <vector>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	vector<int> stack(n); // 입력으로 받는 배열
	vector<int> numarr; // 1, 2, 3,... 숫자를 차례로 입력하는 배열
	vector<char> result; // + - 기록하는 배열

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		stack[i] = a;
	}

	int j = 1;
	bool sign = true;

	for (int i = 0; i < n; i++) {
		if (stack[i] >= j) { // 입력 숫자가 현재 numarr에 들어있는 것보다 크다면 push
			while (stack[i] >= j) { // 같아질 때까지
				numarr.push_back(j);
				result.push_back('+'); // + 기록
				j++;
			}
			numarr.pop_back(); // 같아지면 pop
			result.push_back('-'); // - 기록
		}
		else {  // 입력 숫자가 현재 numarr에 들어있는 것보다 작다면
			if (numarr.back() != stack[i]) { // 제일 top에 있는 것(마지막에 들어온 값) 비교해서 같지 않으면
				cout << "NO\n" << ' '; // NO 출력
				sign = false; 
				break;
			}
			else {
				result.push_back('-'); // 마지막에 들어온 값과 비교해서 같으면 - 기록
				numarr.pop_back();
			}
		}
		
	}

	if (sign) { // 정상 수열만 출력
		for (int i = 0; i < result.size(); i++) {
			cout << result[i] << '\n';
		}
	}

	return 0;
}
