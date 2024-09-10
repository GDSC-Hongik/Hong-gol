#include <string>
#include <vector>
#include <string>

using namespace std;

int solution(int N, int number) {
    // 8번보다 많이 사용된 경우 -1 디폴트 리턴
    int answer = -1;
    
    if (N == number) {
        return 1; // N이랑 number 같으면 그 자체가 최솟값으로 표현되므로 1 리턴
    }
    
    // N이 각각 1, 2, 3 ... 8번 쓰인 계산을 담을 배열
    vector<vector<int>> dp(9);
    
    for (int i=0; i<9; i++) {
        // 5 55 5555 55555... 만들기
        // 이후 연산에 사용할 기본 숫자들
        
        string str = to_string(N);
        string tmp = "";
        
        // tmp에 (i+1)번 이어붙이기
        for (int j=0; j<i+1; j++) {
            tmp += str;
        }
        
        // 다시 int 변환해서 저장
        dp[i].push_back(stoi(tmp));
    }
    
    for (int i=1; i<9; i++) {
        for (int j=0; j<i; j++) {
            for (auto x: dp[j]) {
                for (auto y: dp[i-j-1]) { 
                    // i = 3 일 때 dp[3] 연산하기
                    // j = 0이면, dp[0]과 dp[2]의 값을 조합
                    // j = 1이면, dp[1]과 dp[1]의 값을 조합
                    // j = 2이면, dp[2]과 dp[0]의 값을 조합
                    // 이 과정으로 연산횟수 i=3개로 만들 수 있는 모든 가능한 숫자 저장
                    dp[i].push_back(x+y);
                    dp[i].push_back(x-y);
                    dp[i].push_back(x*y);
                    if (y!=0) {
                        dp[i].push_back(x/y);
                    }
                }
            }
        }
        
        // i 배열 돌면서 목표 숫자를 만나면 i+1 해줌
        for (auto num: dp[i]) {
            if (num == number) {
                // dp[n]에는 n+1개의 N을 사용하여 만들 수 있는 숫자들이 저장되므로 +1을 해주는 것
                answer = i+1; 
                break;
            }
        }
        
        // -1이 아니면 최소 연산 횟수 구한 것이므로 break
        if (answer != -1) {
            break;
        }
        
    }
    return answer;
    
}