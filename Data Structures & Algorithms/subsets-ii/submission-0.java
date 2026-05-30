class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res= new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,new ArrayList<>(),nums);
        return res;
    }
    public void backtrack(int i, List<Integer> subset, int[] nums){
        if(i==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i+1,subset,nums);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        subset.remove(subset.size()-1);
        backtrack(i+1,subset,nums);
    }
}
