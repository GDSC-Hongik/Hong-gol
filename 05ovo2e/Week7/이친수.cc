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

	if (n == 1) {
		// n이 1일 때는 이친수는 1만 가능
		cout << 1;
		return 0;
	}

	long long answer = 0;

	long long dp[91][2];

	// dp[i][0]: i 길이에서 끝이 0으로 끝나는 이친수의 개수
	// 10, 00 같은 경우
	// dp[i][1]: i 길이에서 끝이 1으로 끝나는 이친수의 개수
	// 01 같은 경우

	dp[1][1] = 1;
	dp[1][0] = 0; // 0은 이친수 시작할 수 없음

	for (int i = 2; i <= n; i++) {
		dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
		dp[i][1] = dp[i - 1][0];
	}

	answer = (dp[n][0] + dp[n][1]);
	cout << answer;
	return 0;
}