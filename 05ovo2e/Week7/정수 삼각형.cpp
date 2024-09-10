#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;

    // 밑->위로 올라가면서 계산
    for (int i = triangle.size() - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            // 현재 위치에서 가능한 두 경로 중 큰 값을 선택
            triangle[i-1][j] += max(triangle[i][j],triangle[i][j+1]);
        }
    }
    return triangle[0][0];
}