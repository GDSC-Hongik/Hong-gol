#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());
    int len = phone_book.size();
    
    for (int i = 0; i < len - 1; ++i) {
        if (phone_book[i + 1].substr(0, phone_book[i].size()) == phone_book[i]) {
            answer = false;
            return answer;
        }
    }
    
    return answer;
}