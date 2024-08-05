#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    queue<pair<int, int>> prioritiesQueue;
    for (int i=0; i<priorities.size(); i++) {
        prioritiesQueue.push({priorities[i], i});
    }
    
    // 내림차순 정렬
    sort(priorities.begin(), priorities.end(), greater<int>());
    int order = 0;
    
    while (!prioritiesQueue.empty()) {
        int currentPriority = prioritiesQueue.front().first; // priorities
        int currentIndex = prioritiesQueue.front().second; // location
        prioritiesQueue.pop();
        
        if (currentPriority == priorities[order]) {
            order++;
            if (currentIndex == location) {
                 return order;
            }
        }
        else {
            prioritiesQueue.push({currentPriority, currentIndex});
        }
    }  

}

    