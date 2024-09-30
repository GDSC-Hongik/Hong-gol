#include <string>
#include <vector>

using namespace std;
vector<int> visited;
vector<vector<int>> adj; // [컴퓨터 번호, [연결된 컴퓨터 번호]]이므로 2차원 배열

void DFS(int u){
    visited[u] = 1;

    for(int v : adj[u]){
        if(visited[v] == 0){
            DFS(v);
        }
    }
    return;
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    adj.resize(n);
    visited.resize(n, 0);
    
    for (int i =0; i< n; i++) {
        for (int j=i+1; j<n; j++) {
            if (computers[i][j] == 1) {
                adj[i].push_back(j);
                adj[j].push_back(i); // 양쪽 모두 추가
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            DFS(i);  // 방문하지 않은 노드에 대해 DFS 실행
            answer++;  // 하나의 네트워크를 탐색할 때마다 증가
        }
    }

    return answer;
}