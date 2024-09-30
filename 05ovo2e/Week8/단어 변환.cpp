#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

// 두 문자열이 하나의 문자만 다른지 확인하는 함수
bool checkString(const string& a, const string& b) {
    int cnt = 0;
    for (int i = 0; i < a.size(); i++) {
        if (a[i] != b[i]) {
            cnt++;
            if (cnt > 1) return false;
        }
    }
    return cnt == 1;
}

int solution(string begin, string target, vector<string> words) {
    if (find(words.begin(), words.end(), target) == words.end()) {
        return 0; // target이 words 안에 없으면 변환 불가능
    }

    int n = words.size();
    vector<vector<int>> adj(n);
    vector<int> visited(n, 0);

    // 간선 생성
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (checkString(words[i], words[j])) {
                adj[i].push_back(j);
                adj[j].push_back(i); // 양방향 연결
            }
        }
    }

    // BFS 탐색
    queue<pair<int, int>> q; // (인덱스, 거리)
    for (int i = 0; i < n; i++) {
        if (checkString(begin, words[i])) {
            q.push({i, 1}); // 시작 노드와 연결된 노드의 거리 1
            visited[i] = 1;
        }
    }

    while (!q.empty()) {
        auto [current, dist] = q.front();
        q.pop();
        
        if (words[current] == target) {
            return dist;
        }
        
        // 현재 노드와 연결된 노드를 탐색
        for (int neighbor : adj[current]) {
            if (!visited[neighbor]) {
                visited[neighbor] = 1;
                q.push({neighbor, dist + 1});
            }
        }
    }
    
    return 0;
}