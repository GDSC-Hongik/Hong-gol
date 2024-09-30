#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <unordered_map>

using namespace std;
vector<string> answer;
bool found = false;

// 모든 티켓을 사용해야 하므로 DFS 사용
void dfs(const string& current, 
         unordered_map<string, vector<pair<string, bool>>>& adj,
         vector<string>& route, 
         int ticketCount) {
    
    if (route.size()==ticketCount+1) { 
        // 현재 경로가 출발지 공항(ICN)을 포함한 모든 티켓을 사용한 상태
        // 총 티켓 수보다 커지면(+1) 모든 티켓 사용한 것
        answer = route; // 현재 route가 답으로 저장
        found = true; // 탐색 중지
        return;
    }
    
    for (auto& [next, used] : adj[current]) {
        if (!used&&!found) { // 사용되지 않았고 경로 계속 찾는 경우
            used = true; // 티켓 사용한 걸로 표시
            route.push_back(next); // 다음 공항 이동, 업데이트
            dfs(next, adj, route, ticketCount); // 재귀 호출해서 탐색 계속하기
            route.pop_back();  // 백트래킹, 현재 경로에서 마지막 공항을 제거 , 다른 경로를 탐색할 때 이전 상태로 돌아감
            used = false; // 사용한 티켓 상태 초기화
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    
    // 출발지 공항, <목적지 공항, 사용 여부>
    unordered_map<string, vector<pair<string, bool>>> adj; 
    
    // 항공권 개수
    int ticketCount = tickets.size();
    
    // 출발지(ticket[0])를 기준으로 티켓을 정렬
    // emplace_back: 컨테이너의 끝에서 직접 객체를 생성
    for (const auto& ticket : tickets) {
        adj[ticket[0]].emplace_back(ticket[1], false);
    }

    // 목적지 공항 정렬
    for (auto& [key, dest] : adj) {
        sort(dest.begin(), dest.end());
    }
    
    vector<string> route = {"ICN"}; // 출발지 설정
    dfs("ICN", adj, route, ticketCount);
    
    return answer;
}