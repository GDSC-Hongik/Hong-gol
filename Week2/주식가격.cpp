#include <string>
#include <vector>
#include <deque>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    deque <int> q;
    
    for (int i=0; i<prices.size();i++){
        q.push_back(prices[i]);
    }
    
    while (!q.empty()) {
        int time=q.front();
        int count=0;
        q.pop_front();
        
        for (int i=0; i<q.size();i++) {
            count++;
            if (time>q[i]) {
                break;
            }
        }        
        answer.push_back(count);
        

    }
    return answer;
}