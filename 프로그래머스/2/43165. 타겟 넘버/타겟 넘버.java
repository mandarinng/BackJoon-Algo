class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0,0, numbers, target);
        
        return answer;
    }
    public static void dfs(int node, int sum, int[] numbers, int target){
        if(node == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(node+1, sum + numbers[node], numbers, target);
        dfs(node+1, sum - numbers[node], numbers, target);
        
    }
}