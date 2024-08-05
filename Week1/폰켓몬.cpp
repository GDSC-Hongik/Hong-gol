#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int type = ( nums.size() ) /2; // 총 N 마리의 폰켓몬 중에서 N/2마리까지 가져갈 수 있다.
    set<int> snums(nums.begin(),nums.end());   // 폰켓몬 종류의 개수 구하기
    int stype = (snums.size());
    if (stype>type) { // 폰켓몬 종류가 최대 가져갈 수 있는 마리보다 많으면 최대 가져갈 수 있는 마리가 종류의 수가 됨
        // 5 종류인데 2마리까지 가져갈 수 있다면 종류 다섯개 중에 2개 고르는 것
        answer = type;
        
    }
    else { // 폰켓몬 종류보다 가져갈 수 있는 마리가 많다면 모든 종류를 다 가져갈 수 있다
        // 5 종류인데 6마리까지 가져갈 수 있다면 5 종류를 모두 가져갈 수 있다.
        answer = stype;
    }
    
    return answer;
}