#include <string>
#include <vector>

using namespace std;
// 7, 3, 9
// 5, 10, 1, 1, 20, 1

vector<int> solution(vector<int> progresses, vector<int> speeds) {

    vector<int> release(0);
    vector<int> answer(0);
    
    for (int a: progresses) {
        int b= speeds.front();
        if ((100-a)%b==0) {
            release.push_back((100-a)/b);
            speeds.erase(speeds.begin());
        }
        else {
            release.push_back(((100-a)/b)+1);
            speeds.erase(speeds.begin());
        }
    }
    
    while (!release.empty()) {
        int daysRequired = release.front();
        int count = 0;

        // release 벡터에서 daysRequired보다 작거나 같은 모든 요소를 처리
        while (!release.empty() && release.front() <= daysRequired) {
            count++;
            release.erase(release.begin());
        }

        answer.push_back(count);
    }

     return answer;
}