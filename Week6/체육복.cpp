#include <iostream>
#include <vector>
#include <algorithm> // std::sort, std::set_intersection
#include <iterator>  // std::ostream_iterator

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    
    vector<int> common;

    // 벡터의 크기를 기준으로 공통 원소를 찾기 위한 벡터 크기 설정
    common.resize(min(lost.size(), reserve.size()));

    // 두 벡터의 공통 원소를 찾기
    auto it = set_intersection(
        lost.begin(), lost.end(),
        reserve.begin(), reserve.end(),
        common.begin()
    );
    
    // 공통 요소의 실제 크기로 벡터 크기 조정
    common.resize(it - common.begin());

    // 공통 요소를 삭제
    for (int elem : common) {
        lost.erase(remove(lost.begin(), lost.end(), elem), lost.end());
        reserve.erase(remove(reserve.begin(), reserve.end(), elem), reserve.end());
    }

    for (int i=0; i<lost.size(); i++) {
        for (int j=0; j<reserve.size(); j++) {
            if (lost[i]+1 == reserve[j] || lost[i]-1 == reserve[j]) {
                lost[i] = 0;
                // 여벌 빌려준 학생 삭제
                reserve.erase(remove(reserve.begin(), reserve.end(), reserve[j]), reserve.end());
                break;  // 다음 잃어버린 학생으로 넘어감
            }
        }
    }
    
    int totalSize = lost.size();
    int zeroCount = count(lost.begin(), lost.end(), 0);
    answer = n - ( totalSize - zeroCount );
    
    return answer;
}