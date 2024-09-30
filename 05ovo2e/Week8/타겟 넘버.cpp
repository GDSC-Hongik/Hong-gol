#include <string>
#include <vector>
#include <iostream>
using namespace std;

int DFS(vector<int>& numbers, int target, int index, int sum){
    if (index == numbers.size()) {
        if (sum == target) return 1;
        else return 0;
    }
    
    return DFS(numbers, target, index+1, sum + numbers[index]) +
        DFS(numbers, target, index+1, sum - numbers[index]);
}

int solution(vector<int> numbers, int target) {
    return DFS(numbers, target, 0, 0);
}