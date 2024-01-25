class Solution {
    public int solution(int[] numbers) {
        int answ = 0;
        int[] answer = new int[10];
        
        for(int i=0; i<numbers.length; i++) {
            answer[numbers[i]] = 1;
        }

        for(int i=0; i<answer.length; i++) {
            if(answer[i] == 0) {answ += i;}
        }
        
        return answ;
    }
}