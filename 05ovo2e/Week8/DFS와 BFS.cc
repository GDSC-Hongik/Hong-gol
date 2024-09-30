#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>
#include <cctype>

using namespace std;

vector<int> visited_dfs; // dfs
vector<int> visited_bfs; // bfs
vector<vector<int>> adj; // 인덱스, 해당 인덱스와 연결된 인덱스
vector<int> edge;
queue<int> q;

void DFS(int u) {
	cout << u << " ";
	visited_dfs[u] = 1;

	for (int v : adj[u]) {
		if (visited_dfs[v] == 0) {
			DFS(v);
		}
	}
	return;
}

void BFS(int u) {
	cout << u << " "; // 시작 노드 출력
	visited_bfs[u] = 1;
	q.push(u);
	
	while (q.size()) {
		u = q.front();
		q.pop();
		for (int v : adj[u]) { // 현재 노드 u에 인접한 모든 노드 v를 순회
			if (visited_bfs[v] == 0) {
				visited_bfs[v] = 1; // 방문되지 x -> 방문 처리
				q.push(v); // 큐에 추가
				cout << v << " ";
			}
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, v;
	int answer = 0;
	
	cin >> n >> m >> v; // 노드의 개수, 엣지의 개수

	adj.resize(n+1); // 1부터 n까지 사용하기 위해서
	visited_dfs.resize(n+1, 0);
	visited_bfs.resize(n + 1, 0);

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y; 
		edge = { x, y };
		adj[x].push_back(y); // 인접 리스트 연결
		adj[y].push_back(x);
	}
	
	// 1차원 벡터 정렬하면 안됨.. : sort(adj.begin(), adj.end());
	// 인접리스트 순회하며 정렬 적용s
	for (int i = 0; i < adj.size(); i++) {
		sort(adj[i].begin(), adj[i].end());
	}

	DFS(v);
	cout << endl;
	BFS(v);

	return 0;
}