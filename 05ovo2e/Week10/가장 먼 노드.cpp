#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

// BFS를 사용
// 시작 노드에서 한 레벨씩 탐색하므로, 시작점에서 특정 노드까지의 경로 중 최단 경로를 찾을 수 있다.

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    vector<vector<int>> adj(n);
    vector<int> distance(n, -1);
    queue<int> q;
    
    // 인접 리스트로 그래프 표현
    for (const auto& e : edge) {
        adj[e[0] - 1].push_back(e[1] - 1); // 0-based 인덱싱
        adj[e[1] - 1].push_back(e[0] - 1); // 양방향 추가
    }
    
    distance[0] =0; // 노드 1번은 distance 0
    q.push(0);
    
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        
        for (int next : adj[node]) {
            if (distance[next] == -1) { // 방문하지 않은 노드
                distance[next] = distance[node] +1; // 기존 노드 거리에 +!
                q.push(next); // 다음 노드로 넘어가기
            }
        }
    }
    
    sort(distance.begin(), distance.end()); // 오름차순 정렬
    
    int max_distance = distance.back(); // 마지막에 있는 값이 최댓값
    answer = count(distance.begin(), distance.end(), max_distance); // 배열에서 최댓값 몇 개인지 세기
    
    return answer;
}