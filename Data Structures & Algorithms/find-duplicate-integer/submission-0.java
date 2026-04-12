class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0, fast=0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int sec=0;
        while(true){
            sec=nums[sec];
            slow=nums[slow];
            if(slow==sec){
                return sec;
            }
        }
    }
}
