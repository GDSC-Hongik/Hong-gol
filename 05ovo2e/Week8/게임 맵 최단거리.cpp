#include<vector>
#include <queue>
#include <tuple>

using namespace std;

// 가중치가 같은 그래프 내의 최단거리 알고리즘
// 한 칸씩 이동할 수 있으므로
// BFS로 최단거리 배열을 만든다.

const int max_n = 104;
int dy[4] = {-1, 0, 1, 0}; // 상하
int dx[4] = {0, 1, 0, -1}; // 좌우
int n, m, visited[max_n][max_n], y, x;

int solution(vector<vector<int>> maps)
{
    int answer = 0;
    
    n = maps.size();
    m = maps[0].size();
    
    queue<pair<int, int>> q;
    
    visited[0][0] = 1;
    q.push({0, 0});
    
    while (q.size()) {
        tie(y,x) = q.front();
        q.pop();
        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || maps[ny][nx] == 0)
                continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny, nx});
        }
    }
    
    if (visited[n-1][m-1] == 0) {
        return -1;
    }

    return visited[n-1][m-1];
}