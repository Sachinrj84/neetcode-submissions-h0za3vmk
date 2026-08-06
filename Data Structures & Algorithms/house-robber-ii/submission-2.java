class Solution {
    int[] fm;
    int[] sm;
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        fm= new int[nums.length];
        sm= new int[nums.length];
        Arrays.fill(fm,-1);
        Arrays.fill(sm,-1);
        int n= nums.length;
        int first=dfs(nums, 0, n-1,fm);
        int second=dfs(nums, 1,n, sm);
        return Math.max(first, second);
    }

    public int dfs(int[] nums, int i, int n, int[] memo){
        if(i>=n) return 0;
        if(memo[i]!=-1){
            return memo[i];
        }
        memo[i]= Math.max(dfs(nums, i+1, n, memo), nums[i]+dfs(nums, i+2, n, memo));
        return memo[i];
    }
}
