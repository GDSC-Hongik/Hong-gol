class Solution {
    public String solution(String number, int k) {
        String answer = "";
        //String은 불변 객체, StringBuilder는 내부적으로 가변적인 버퍼를 사용
        StringBuilder answerBuilder = new StringBuilder();

        char[] arr = number.toCharArray();
        int len = arr.length - k;
        
        // 문자 비교를 시작하는 인덱스
        int start = 0;

        for(int i =0; i<len; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                if(arr[j] > max){
                    max = arr[j];
                    start=j+1;
                }
            }
            answerBuilder.append(max);
        }
        
        answer = answerBuilder.toString();
        
        return answer;
    }
    
}