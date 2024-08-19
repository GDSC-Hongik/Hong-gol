#include <iostream>
#include <queue>
#include <vector>
#include <cmath> // abs 또는 fabs를 사용하기 위해 포함

using namespace std;


int main() {
	
	int n;
	cin >> n;
	cin.ignore(); // 남아있는 개행 문자를 무시

	vector<int> ans;
	

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		ans.push_back(a);
	}

	for (int i = 0; i < n-1; i++) {
		for (int j = 0; j < n - 1 - i; j++) {
			int tmp = 0;
			if (ans[j] > ans[j + 1]) {
				tmp = ans[j];
				ans[j] = ans[j + 1];
				ans[j + 1] = tmp;
			}
		}

	}

	for (int v : ans) {
		cout << v << '\n';
	}

	return 0;
}

