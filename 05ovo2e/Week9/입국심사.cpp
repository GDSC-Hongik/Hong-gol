#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

long long solution(int n, vector<int> times) {
    
    long long left = 1;
    // 가장 큰 심사 시간을 찾고, 최대 범위 설정
    long long right = *max_element(times.begin(), times.end()) * (long long)n;  
    
    long long answer = right;
    
    while (left <= right) {
        long long mid = (left + right) / 2; 
        long long total = 0; 

        // 각 심사관이 mid 시간 내에 몇 명을 처리
        for (int time : times) {
            total += mid / time;
            if (total >= n) break;  // n명을 넘으면 더 계산할 필요 없음
        }

        // 처리 가능한 사람 수가 n명 이상이면 시간 줄이기
        if (total >= n) {
            answer = mid;
            right = mid - 1;
        } else {  // 처리 가능한 사람 수가 부족하면 시간 늘리기
            left = mid + 1;
        }
    }
        
    return answer;

}
