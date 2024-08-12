#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
	
	int n;
	cin >> n;
	cin.ignore(); // 남아있는 개행 문자를 무시

	vector<int> arr(n); // 비교할 숫자 배열
	vector<int> numarr(n, -1); // 오큰수 배열
	stack<int> s; // 인덱스를 저장할 스택

	for (int i = 0; i < n; i++) {
		cin >> arr[i]; // 띄어쓰기로 구분된 숫자들을 배열에 저장
	}

	for (int i = 0; i < n; i++) {
		while (!s.empty() && arr[i] > arr[s.top()]) {
			numarr[s.top()] = arr[i];
			s.pop();
		}

		s.push(i);
		
	}

	for (int i = 0; i < n; i++) {
		cout << numarr[i] << " ";
	}
	
	return 0;
}

