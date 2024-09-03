#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());

    int left = 0;
    int right = people.size() -1;
   
    while (left <= right) {
        // 첫번째랑 마지막 비교
        if (people[left] + people[right] <= limit) {
            left++;
        }
        // 조건 만족하지 않으면 마지막-1해서 비교
        right--;
        answer++;
    }

    return answer;
}