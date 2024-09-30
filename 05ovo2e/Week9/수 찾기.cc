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

	int n;
	cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	sort(a.begin(), a.end());
	
	int m;
	cin >> m;
	

	for (int i = 0; i < m; i++) {
		bool check = false;
		int target;
		
		cin >> target;
		
		int start = 0;
		int end = n-1;
		while (start <= end) {
			int mid_idx = (start + end) / 2;
			int mid_value = a[mid_idx];
			
			if (mid_value > target) {
				end = mid_idx - 1;
			}

			else if (mid_value < target) {
				start = mid_idx + 1;
			}

			else { cout << 1 << '\n'; check = true; break; }
		}

		if (!check) {
			cout << 0 << '\n';
		}
	}

	return 0;
}