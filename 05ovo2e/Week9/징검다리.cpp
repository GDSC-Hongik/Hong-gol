#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int distance, vector<int> rocks, int n) {
   
    sort(rocks.begin(), rocks.end());
    // left는 최소 거리, right는 최대 거리(출발지와 도착지의 거리)
    // 중간값 `mid`를 최소 거리로 하여, 
    // 주어진 조건에 맞추어 바위를 제거하는 조건을 확인하면서 left와 right의 값을 조정
    rocks.push_back(distance);
    int left = 1;
    int right = distance;
    long long answer = right;
    
     while (left <= right) {
        int mid = (left + right) / 2; 
        int prev = 0;
        int remove_rock = 0; 
         
         for (int rock : rocks) {
            if (rock - prev < mid) {
                remove_rock++;
            }
            else {
                prev = rock;
            }
        }

        if (remove_rock > n) {
            right = mid - 1;
        } else {
            answer = mid;
            left = mid + 1;
        }
    }
    
    return answer;
}


    