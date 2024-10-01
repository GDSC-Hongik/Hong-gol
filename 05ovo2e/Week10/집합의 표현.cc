#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>
#include <string>
#include <cctype>

using namespace std;
vector<int> parent(1000001);


int find(int a) { // 대표 노드 찾기

	if (a == parent[a]) { // 자신이 대표노드면 자신을 return
		return a;
	}
	else { // 아니면 재귀로 자신의 대표노드 값을 찾아서 return
		return parent[a] = find(parent[a]);
	}
}

void unionfunc(int a, int b) {
	a = find(a);
	b = find(b);

	if (a != b) { // 대표노드 다르면 a의 대표노드로 지정해 줌
		parent[b] = a;
	}
}

bool checkSame(int a, int b) { // 두 원소가 같은 집합인가 = 대표 노드 같은가
	if (find(a) == find(b)) {
		return true;
	}
	else { return false; }
}

int main() {
	std::ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n; // 원소 개수
	cin >> m; // 질의 개수

	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}

	for (int i = 0; i < m; i++) {
		int q, a, b;
		cin >> q >> a >> b;
		if (!q) {// 0이면 union
			unionfunc(a, b);
		}
		else { // 1이면 find
			if (checkSame(a, b)) {
				cout << "YES" << "\n";
			}
			else {
				cout << "NO" << "\n";
			}
		}
	}
	return 0;
}