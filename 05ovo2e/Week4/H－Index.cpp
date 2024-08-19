#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(), citations.end());

    for (int i=0; i< citations.size(); ++i){
        int c = citations[i];
        int least = citations.size()-i;
        if (c >= least) {
            answer = least;
            break;
        }
    }
   
    return answer;
}