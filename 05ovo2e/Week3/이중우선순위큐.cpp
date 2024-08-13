#include <iostream>
#include <sstream> // std::istringstream
#include <vector>
#include <string>
#include <queue>
#include <map>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    
    // 최대 힙
    priority_queue<int> maxHeap;
    // 최소 힙
    priority_queue<int, vector<int>, greater<int>> minHeap;
    // 지연 삭제 추적
    map<int, int> delayed; // 상대 큐에서 삭제된 숫자 추적

    for (const string& operation : operations) {       
        istringstream iss(operation);
        string type;
        int value;
        iss >> type >> value;

        if (type == "I") {
            maxHeap.push(value);
            minHeap.push(value);
            delayed[value]++; // insert되면 값이 있다는 것을 표시(1로)
        } else if (type == "D") {
            if (value == 1) { // 최대값 삭제
                while (!maxHeap.empty() && delayed[maxHeap.top()] == 0) { 
                    // 힙이 비어있지 않은데 값이 0이라면 삭제되었단 뜻이므로 동기화
                    maxHeap.pop();
                }
                if (!maxHeap.empty()) {
                    // 최댓값 꺼내와서 삭제하고 그 최댓값이 삭제된 것 업데이트
                    int maxVal = maxHeap.top();
                    maxHeap.pop();
                    delayed[maxVal]--;
                }
            } else if (value == -1) { // 최소값 삭제
                while (!minHeap.empty() && delayed[minHeap.top()] == 0) {
                    // 힙이 비어있지 않은데 값이 0이라면 삭제되었단 뜻이므로 동기화
                    minHeap.pop();
                }
                if (!minHeap.empty()) {
                    // 최솟값 꺼내와서 삭제하고 그 최솟값 삭제된 것 업데이트
                    int minVal = minHeap.top();
                    minHeap.pop();
                    delayed[minVal]--;
                }
            }

        }
        
        // 힙 검사해서 삭제 연산 동기화
        while (!maxHeap.empty() && delayed[maxHeap.top()] == 0) {
            maxHeap.pop();
        }
         while (!minHeap.empty() && delayed[minHeap.top()] == 0) {
             minHeap.pop();
         }
    }

    // 결과 결정
    if (maxHeap.empty() || minHeap.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    } else {
        answer.push_back(maxHeap.top());
        answer.push_back(minHeap.top());
    }

    return answer;
}
