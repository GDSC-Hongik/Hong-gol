#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>
#include <cctype>

using namespace std;
static string a;
static string b;
static vector<char> path;
static vector<vector<int>> dp;

void getPath(int x, int y) {
	if (x == 0 || y == 0) { // 문자열이 한 쪽이라도 없으면 종료
		return;
	}
	if (a[x-1]==b[y-1]) { // 문자 같으면 
		path.push_back(a[x - 1]); // 해당 문자 기록(a든 b든 상관없음)
		getPath(x - 1, y - 1); // 왼쪽 위로 이동 (재귀함수)
	}
	else { // 문자 다르면
		if (dp[x - 1][y] > dp[x][y - 1]) { // 왼쪽이 더 큰 경우
			getPath(x - 1, y); // 왼쪽으로 이동
		}
		else { // 윗쪽이 더 큰 경우
			getPath(x, y-1); // 윗쪽으로 이동
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	cin >> a;
	cin >> b;

	int a_len = a.length();
	int b_len = b.length();

	// dp 벡터의 크기를 resize로 동적 할당
	dp.resize(a_len + 1, vector<int>(b_len + 1));

	for (int i = 1; i <= a_len; i++) {
		for (int j = 1; j <= b_len; j++) {
			if (a[i-1] == b[j-1]) { // 문자열 동일하면
				dp[i][j] = dp[i - 1][j - 1] + 1; // 오른쪽, 아랫쪽으로 이동 + 1
			}
			else { // 동일하지 않으면 왼, 윗쪽에서 큰 값 저장
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	cout << dp[a_len][b_len] << endl; // LCS 최장공통부분 수열 출력
	getPath(a_len, b_len); // 문자열 출력 함수 호출

	// path.size() - 1부터 0까지 출력
	for (int i = path.size()-1; i >= 0; i--) { 
		// 역순으로 저장되어서 마지막 인덱스부터 출력
		cout << path[i];
	}

	return 0;
}