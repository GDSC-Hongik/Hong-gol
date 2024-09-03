#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

// 모든 섬이 연결되었을 때 true 리턴
bool countTrue(const vector<bool>& check) {
//      int count = 0;
    
//      for (bool value : check) {
//          if (value) {
//              ++count;
//          }
//      }
    
//      if (count==check.size()) {
//          return true;
//      }
    
//      return false;
    return all_of(check.begin(), check.end(), [](bool value) { return value; });
 
}

int solution(int n, vector<vector<int>> costs) {
    
    vector<vector<pair<int, int>>> graph(n);
    
    for (const auto& cost : costs) {
        int start = cost[0];
        int end = cost[1];
        int weight = cost[2];
        graph[start].push_back({end, weight});
        graph[end].push_back({start, weight});
    }
    
     priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    vector<bool> inMST(n, false);
    int answer = 0;
    pq.push({0, 0}); // {비용, 노드}
    
    while (!pq.empty()) {
        auto [cost, node] = pq.top();
        pq.pop();
        
        // 이미 MST에 포함된 노드면 무시
        if (inMST[node]) {
            continue;
        }
        
        // MST에 현재 노드 추가
        inMST[node] = true;
        answer += cost;
        
        // 현재 노드와 연결된 모든 간선을 우선순위 큐에 추가
        for (const auto& [neighbor, edgeCost] : graph[node]) {
            if (!inMST[neighbor]) {
                pq.push({edgeCost, neighbor});
            }
        }
    }
    
    return answer;
}