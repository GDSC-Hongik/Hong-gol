#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 4 > ( 3 1 ) > 2 > 5 

// 플로이드-워셜(Floyd-Warshall) 알고리즘: 모든 정점 간의 최단 경로 구하기
// i가 j를 이기고, j가 k를 이겼다면 i가 k를 이겼다는 것을 도출

// 플로이드-워셜 알고리즘 시간 복잡도는 O(n^3)
// n이 100 이하일 경우, 충분히 해결 가능하다

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    // 일단 모두 패배한 걸로 초기화
    vector<vector<int>> adj(n, vector<int>(n, 1e9)); 
    
    // 자기 자신 0으로 설정
    for (int i = 0; i < n; i++) {
        adj[i][i] = 0;
    }
    
     // 인접 리스트로 그래프 표현
    for (const auto& result : results) { // -1 하는 건 0-based로 바꾸기 위해서
        int winner = result[0] -1;
        int loser = result[1] -1;
        adj[winner][loser] =1; // 이긴 경우
    }
    
    // 플로이드-워셜 적용
    for (int k =0; k<n; k++) {
        for (int i = 0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // adj[i][j] : i에서 j로 가는 최단 경로의 거리
                // adj[i][k] + adj[k][j] : i → k → j로 가는 경유 경로의 거리
                // 지금 거리 > 경유 경로? 그 값으로 adj[i][j]를 갱신
                if (adj[i][j] > adj[i][k] + adj[k][j]) {
                    adj[i][j] = adj[i][k] + adj[k][j];
                }
            }
        }
    }
    
    // 승패 결정되어서 값이 갱신되었는지 확인
    for (int i=0; i<n; i++) {
        int count = 0;
        for (int j=0; j<n; j++) {
            if (adj[i][j] != 1e9 || adj[j][i] != 1e9) {
                count++;  // 경로 설정된 선수라면 count 증가
            }
            if (count == n) {
                answer++;
            }
        }
    }
    
    return answer;
}

