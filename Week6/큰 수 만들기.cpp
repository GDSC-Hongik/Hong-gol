#include <string>
#include <vector>
#include <algorithm> // std::max_element
#include <iterator>  // std::ostream_iterator

using namespace std;

string solution(string number, int k) {
    /* 조합을 이용한 풀이; 시간 초과 */
    /*
    string answer = "";
    int length = number.size() - k;
    vector<bool> v(number.size());
    fill(v.end() - length, v.end(), true); // 벡터의 끝 부분을 true로 설정
    //벡터의 끝에서부터 true를 설정하면, 조합 생성에서 필요한 부분 집합을 올바르게 선택할 수 있다
    
    do {
        string combination;
        for (int i = 0; i < number.size(); ++i) {
            if (v[i]) {
                combination += number[i];
            }
        }
       answer = max(answer, combination);
    } while (next_permutation(v.begin(), v.end()));
    */
    
    string answer = "";
    int length = number.size() - k;

    for (char c : number) {
        while (!answer.empty() && k > 0 && answer.back() < c) {
            answer.pop_back();
            k--;
        }
        answer.push_back(c);
    }
    
    answer = answer.substr(0, length);
    
    return answer;
}