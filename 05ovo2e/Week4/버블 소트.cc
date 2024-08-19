#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath> // abs 또는 fabs를 사용하기 위해 포함

using namespace std;


int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	cin.ignore(); // 남아있는 개행 문자를 무시

	vector<pair<int, int>> ans(n);
	vector<pair<int, int>> ans_sorted(n);

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		ans[i] = { a, i+1 };
		ans_sorted[i].second = i+1;
	}

	sort(ans.begin(), ans.end());


	/*for (const auto& p : ans) {
		cout << "(" << p.first << ", " << p.second << ") ";
	}

	cout << "\n";

	for (const auto& p : ans_sorted) {
		cout << "(" << p.first << ", " << p.second << ") ";
	}*/
	
	int max = ans[0].second - ans_sorted[0].second;

	for (int i = 0; i < ans.size(); i++) {
		if (max < ans[i].second - ans_sorted[i].second) {
			max = ans[i].second - ans_sorted[i].second;
		}
		/*cout << "현재 최대 값 " << max << '\n';*/
	}

	max++;

	cout << max;
	

	return 0;
}

