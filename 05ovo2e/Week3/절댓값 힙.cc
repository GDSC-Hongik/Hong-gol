#include <iostream>
#include <queue>
#include <vector>
#include <cmath> // abs 또는 fabs를 사용하기 위해 포함

using namespace std;

struct Compare {
	bool operator()(int a, int b) {
		if (abs(a) == abs(b)) {
			return a > b;
		}
		return abs(a) > abs(b);
	}
};
int main() {
	
	int n;
	cin >> n;
	cin.ignore(); // 남아있는 개행 문자를 무시

	priority_queue<int, vector<int>, Compare> heap;
	

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a != 0) {
			heap.push(a);
		}
		else {
			if (heap.empty()) {
				cout << 0 << '\n';
			}
			else {
				cout << heap.top() << '\n';
				heap.pop();
			}
			
		}
		

	}


	return 0;
}

