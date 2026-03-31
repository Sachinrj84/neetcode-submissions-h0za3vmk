class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int l=0, r=n-1;
        int res=nums[0];
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<nums[r]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
