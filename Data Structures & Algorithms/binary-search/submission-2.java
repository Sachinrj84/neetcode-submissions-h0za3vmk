class Solution {
    public int binary_search(int l, int r, int[] nums, int t){
        if(l>r) return -1;
        int m= l+(r-l)/2;
        if(nums[m]==t) return m;
        return (nums[m]<t) ? binary_search(m+1, r, nums, t):
        binary_search(l,m-1, nums, t);

    }
    public int search(int[] nums, int target) {
        return binary_search(0, nums.length-1, nums, target);
    }
}
