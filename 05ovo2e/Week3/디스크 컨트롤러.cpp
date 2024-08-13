#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

struct compare {
    bool operator()(vector<int> u, vector<int> v) {
        return u[1]>v[1];
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    sort(jobs.begin(), jobs.end());
    
    priority_queue<vector<int>, vector<vector<int>>, compare> pq;
    int len = jobs.size();
    int i = 0;
    int time = 0;
    while (i<len || !pq.empty()) {
        if (i<len && jobs[i][0] <= time) {
            pq.push(jobs[i++]);
            continue;
        }
        if (!pq.empty()) {
            time += pq.top()[1]; //현재+작업소요시간
            answer += time-pq.top()[0]; // 총 소요시간-요청시간-> 대기시간
            pq.pop();
        }
        else {
            time = jobs[i][0]; // 비어있으면 다음 작업의 시작 시간으로 설정
        }
    }
    return answer / len;
}