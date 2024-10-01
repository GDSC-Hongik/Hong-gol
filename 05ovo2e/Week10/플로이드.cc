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

	int n, m;
	cin >> n; // 도시 개수
	cin >> m; // 버스 개수

	vector<vector<int>> bus_map(m, vector<int>(3));

	for (int i = 0; i < m; i++) {
		// 시작 도시 a, 도착 도시 b, 비용 c
		int a, b, c = 0;
		cin >> a >> b >> c;

		bus_map[i] = { a, b, c };

	}

	// 초기화
	vector<vector<int>> adj(n, vector<int>(n, 1e9));

	// 자신 도시 0으로 설정
	for (int i = 0; i < n; i++) {
		adj[i][i] = 0;
	}

	// 인접 행렬로 그래프 표현
	for (const auto& bus : bus_map) { // -1 하는 건 0-based로 바꾸기 위해서
		int from = bus[0] - 1;
		int to = bus[1] - 1;
		adj[from][to] = min(adj[from][to], bus[2]);
	}
	
	// 플로이드-워셜 적용
	for (int k = 0; k < n; k++) { // k: 경유지
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// adj[i][j] : i에서 j로 가는 최단 경로의 거리
				// adj[i][k] + adj[k][j] : i → k → j로 가는 경유 경로의 거리
				// 경유지로 가는 경로가 1e9가 아니라면
				// 지금 거리, 경유 경로 중 최솟값 갱신 
				if (adj[i][k] != 1e9 && adj[k][j] != 1e9) {
					adj[i][j] = min(adj[i][j], adj[i][k]+ adj[k][j]);
				}
			}
		}
	}


	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (adj[i][j] == 1e9) { // 경로 없는 경우
				cout << 0 << " ";
			}
			else {
				cout << adj[i][j] << " "; // 최단 경로 출력
			}
		}
		cout << endl;
	}

	return 0;
}