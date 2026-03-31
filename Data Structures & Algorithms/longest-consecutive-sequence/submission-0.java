class Solution {
    public int longestConsecutive(int[] nums) {
        int finalres=0;
        int res=0;
        Set<Integer> set= new HashSet<>();
        for ( int ele: nums){
            if(set.contains(ele)) continue;
            set.add(ele);
        }
        for ( int i=0; i<nums.length;i++){
            int element=nums[i];
            if(set.contains(element)){
                res++;
                element++;
                for( int j=0; j< nums.length;j++){
                    if(set.contains(element)){
                        res++;
                        element++;
                    }
                }
            }
            System.out.println(res);
            if(finalres<res){
                finalres=res;
            }
            res=0;
        }
        return finalres;
    }
}
