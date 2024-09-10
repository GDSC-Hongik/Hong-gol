#include <string>
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
  
    // 경로 수 저장 n x m (1,1)부터 시작해서 n+1, m+1을 초깃값으로
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    
    // 물에 잠긴 위치 표시, bool로 체크
    vector<vector<bool>> is_puddle(n + 1, vector<bool>(m + 1, false));
    
    // 물에 잠긴 위치 저장
    for (const auto& puddle : puddles) {
        is_puddle[puddle[1]][puddle[0]] = true; // 물에 잠긴 위치 표시
    }
    
    
   // (1,1) 초기화
    dp[1][1] = 1;

    for (int row = 1; row <= n; ++row) {
        for (int col = 1; col <= m; ++col) {
            // 시작점 건너뛰기
            if (row == 1 && col == 1) continue;
            
            // 물에 잠긴 경우
            if (is_puddle[row][col]) {
                dp[row][col] = 0;
            } else {
                // 경로 수를 위쪽과 왼쪽에서 더함
                if (row>1) {
                    dp[row][col] += dp[row - 1][col];
                }
                if (col>1) {
                    dp[row][col] += dp[row][col - 1];
                }
                
                dp[row][col] %= 1000000007;
            }
        }
    }
    
    return dp[n][m];
}