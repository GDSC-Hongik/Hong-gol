#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string name) {
    int answer = 0;
    int alphMove[26] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
    int n = name.size();
    int minMove = n-1; // case1) 한 방향으로 마지막까지 이동해야 하는 경우
    
    // case2) 한 방향 이동 후 역방향으로 바뀌는 경우
    // i: 하나의 인덱스, j: i 이후 중에서 A가 아닌 문자의 인덱스
    for (int i=0; i<n; i++) {
        answer += alphMove[name[i]-'A']; // 조이스틱 상하 이동-> 알파벳 고르기
        int j = i + 1; // 현재 보고 있는 문자 바로 뒤부터 시작
        while ( j < n && name[j] == 'A') j++; // A가 아닌 문자 위치 찾기(A면 j++)
        // 오른쪽 i 탐색-원점 복귀-왼쪽 j 탐색: i + i + n-j
        // 왼쪽 j 탐색-원점 복귀-오른쪽 i 탐색: n-j + n-j + i
        minMove = min( minMove, min(i+i+n-j, n-j+n-j+i)); 
    }
    
    answer += minMove;
    
    return answer;
}