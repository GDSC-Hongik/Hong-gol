#include <string>
#include <vector>
#include <algorithm> // std::sort
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for (const auto& command : commands) {
        int s = command[0]-1;
        int e = command[1]-1;
        int idx = command[2]-1;
        vector<int> tmp(array.begin() + s, array.begin() + e + 1);
        sort(tmp.begin(), tmp.end());
        answer.push_back(tmp[idx]);
    }
              
    return answer;
}