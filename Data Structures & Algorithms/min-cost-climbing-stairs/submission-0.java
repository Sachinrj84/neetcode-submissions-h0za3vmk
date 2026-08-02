class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int one=cost[n-1];
        int two=0;
        for(int i=n-2; i>=0;i--){
            int temp=one;
            one=cost[i]+Math.min(one, two);
            two=temp;
        }
        return Math.min(one, two);
    }
}
