#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>
#include <cctype>

using namespace std;
vector<int> visited;
vector<vector<int>> adj; // 인덱스, 해당 인덱스와 연결된 인덱스
vector<int> edge;

void DFS(int u) {
	visited[u] = 1;

	for (int v : adj[u]) {
		if (visited[v] == 0) {
			DFS(v);
		}
	}
	return;
}

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	int answer = 0;
	
	cin >> n >> m; // 노드의 개수, 엣지의 개수

	adj.resize(n+1); // 1부터 n까지 사용하기 위해서
	visited.resize(n+1, 0);

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y; 
		edge = { x, y };
		adj[x].push_back(y); // 인접 리스트 연결
		adj[y].push_back(x);
	}
	
	for (int i = 1; i < n+1; i++) { // 1부터 n까지
		if (!visited[i]) {
			DFS(i);  // 방문하지 않은 노드에 대해 DFS 실행
			answer++;  // 하나의 네트워크를 탐색할 때마다 증가
		}
	}

	cout << answer;

	return 0;
}