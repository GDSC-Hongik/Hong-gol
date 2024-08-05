#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    for (int a : arr) {
        if (answer.empty()) {
            answer.push_back(a);
            continue;
        }
        else if (answer.back() != a) {
            answer.push_back(a);
        }            
	}

    return answer;
}