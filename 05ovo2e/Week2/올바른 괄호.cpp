#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int open = 0;
    int close = 0;
    
    if (s.back() == '(') {
        return false;
        
    }
    
    for (char c : s) {
       if (c == '(') {
           open++;
       }
        else if (c == ')') {
            open--;
        }
        
        if (open < 0) {
            return false;         
        }
    }
    

    // 모든 괄호가 올바르게 닫혔는지 확인
    if (open == 0) {
        return true;
    }

    return false;  // 열린 괄호가 남아있으면 잘못된 문자열


}
