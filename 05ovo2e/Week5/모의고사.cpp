#include <string>
#include <vector>
#include <algorithm> // std::max_element 사용을 위한 헤더
#include <iterator>  // std::distance 사용을 위한 헤더

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> ans_tmp;
    vector<int> a_answer = { 1, 2, 3, 4, 5 };
    vector<int> b_answer = { 2, 1, 2, 3, 2, 4, 2, 5 };
    vector<int> c_answer = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    int a_cnt = 0;
    int b_cnt = 0;
    int c_cnt = 0;
    
    int ans_size = answers.size();
    
    for (int i=0; i<answers.size(); i++) {
        int a_tmp = i%5;
        int b_tmp = i%8;
        int c_tmp = i%10;
        if (answers[i] == a_answer[a_tmp]) {
            a_cnt++;
        }
        if (answers[i] == b_answer[b_tmp]) {
            b_cnt++;
        }
        if (answers[i] == c_answer[c_tmp]) {
            c_cnt++;
        }
    }
    
    ans_tmp.push_back(a_cnt);
    ans_tmp.push_back(b_cnt);
    ans_tmp.push_back(c_cnt);
    
    int maxValue = *max_element(ans_tmp.begin(), ans_tmp.end());

    // 모든 최대 값의 인덱스 찾기
    for (int i = 0; i < ans_tmp.size(); ++i) {
        if (ans_tmp[i] == maxValue) {
            answer.push_back(i+1);
        }
    }
    
    
    return answer;
}