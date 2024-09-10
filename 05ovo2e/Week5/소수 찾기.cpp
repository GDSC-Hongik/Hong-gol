#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>
#include <cmath>

using namespace std;

int is_prime (int n)
{
    if (n < 2) {
        return 0;
    }

    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) return 0;
    }
    return 1;
}

int solution(string numbers) {
    int answer = 0;
    int tmp = 0;
    sort(numbers.begin(), numbers.end());
    set<int> prime_set;
    
    do
    {
        for(int i=1; i<=numbers.size(); ++i) {
            tmp = stoi(numbers.substr(0, i));
            if (is_prime(tmp)) {
                prime_set.insert(tmp);
            }
        }
    } while (next_permutation(numbers.begin(), numbers.end()));
    
    answer = prime_set.size();
    
    return answer;
}