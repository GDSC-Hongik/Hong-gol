#include <iostream>
#include <vector>
#include <stack>
#include <deque>
using namespace std;

int main() {
	
	int n;
	cin >> n;
	cin.ignore(); // 남아있는 개행 문자를 무시

	deque<int> q;

	for (int i = 0; i < n; i++) {
		q.push_back(i+1);

	}

	while (q.size() > 1) {
		int a;
		q.pop_front();
		a = q.front();
		q.pop_front();
		q.push_back(a);
		
	}
	
	cout << q.front();
	return 0;
}

