class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res= new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,new ArrayList<>(), nums,target);
        return res;
    }

    public void dfs(int i, List<Integer> curr, int[] nums, int target){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i>=nums.length || 0>target){
            return;
        }
        curr.add(nums[i]);
        dfs(i,curr,nums, target-nums[i]);
        curr.remove(curr.size()-1);
        dfs(i+1,curr, nums, target);
    }

}
