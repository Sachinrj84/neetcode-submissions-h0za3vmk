class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        HashMap<Integer, Integer> numsMap= new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++){
            numsMap.put(nums[i],i);
        }
        for(int i=0; i< nums.length;i++){
            int secondNumber= target-nums[i];
            if(numsMap.containsKey(secondNumber) && i!= numsMap.get(secondNumber)){
                res[0]=i;
                res[1]=numsMap.get(secondNumber);
                return res;
            }
        }
        return res;
    }
}
