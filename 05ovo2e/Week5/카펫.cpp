#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int area = brown + yellow;
    
    for (int height = 1; height <= sqrt(area); ++height) {
        if (area % height == 0) { // height가 area를 나누어떨어질 때
            int width = area / height;
            // 가로와 세로의 길이와 brown, yellow의 개수 계산
            if ((width - 2) * (height - 2) >= yellow) {
                answer.push_back(width);
                answer.push_back(height);
                return answer;
            }
        }
        
    }
    
    return answer;
}