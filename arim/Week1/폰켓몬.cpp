#include <vector>
#include <set>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int n=nums.size()/2;
    set<int> a;
    for(int i=0; i<nums.size(); i++){
        a.insert(nums[i]);
    }
    if(a.size()<=n) answer=a.size();
    else answer=n;
    
    return answer;
}