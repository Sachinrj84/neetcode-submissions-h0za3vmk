class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int first=dfs(0,n-2,nums);
        int second=dfs(1, n-1, nums);
        return Math.max(first, second);
    }
    public int dfs(int start, int end, int[] nums){
        int rob1=0, rob2=0;
        for(int i=start; i<=end; i++){
            int temp=Math.max(rob1+nums[i], rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }
}
