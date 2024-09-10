#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <numeric>

using namespace std;

int factorial(int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;

    int length = dungeons.size();
    int total = factorial(length);
    vector<int> count(length, 0);
    
    // index 위치를 표시하는 배열
    vector<int> index(length);
    
    // 벡터를 0부터 시작하는 연속적인 값으로 채움
    iota(index.begin(), index.end(), 0);
    
    // 2차원 벡터를 저장하는 3차원 벡터
    vector<vector<vector<int>>> ans; 
    
    // 인덱스를 섞어서 해당하는 내용을 추가하기
    do {
        vector<vector<int>> content; 
        for (int idx: index) {
            content.push_back(dungeons[idx]);
        }
        ans.push_back(content);
    } while (next_permutation(index.begin(), index.end()));
    
    for (const auto& perm : ans) {
        int current = k;
        int count = 0;
        
        for (const auto& p : perm) {
            if (current >= p[0]) {
                current -= p[1];
                count++;
            }
            else { break; }
        }
        answer = max(answer, count);
        
    }

    return answer;
}