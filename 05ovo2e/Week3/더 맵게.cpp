#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, std::vector<int>, greater<int>> heap;
    for (int value : scoville) {
        heap.push(value);
    }
    int calc = 0;
    
    if (heap.top() >= K) {
        return 0;
    }
    
    while (heap.size()>1) {
        int num_first = heap.top();
        heap.pop();
        int num_second = heap.top();
        heap.pop();
        calc = num_first + (num_second*2);
        answer++;
        heap.push(calc);
        
        if (heap.top()>=K) {
            return answer;
        }
    }
    
    return heap.top() < K ? -1 : answer;
}