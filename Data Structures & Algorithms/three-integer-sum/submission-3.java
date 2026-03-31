class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            if(nums[i] > 0) break;
            int l= i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+ nums[l]+ nums[r];
                if(sum==0){
                    set.add( Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }else if(sum>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
