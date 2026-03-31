class Solution {
    public int trap(int[] height) {
        int res=0;
        int n=height.length;
        int[] prefixMax= new int[n];
        int[] sufixMax= new int[n];
        prefixMax[0]=height[0];
        sufixMax[n-1]=height[n-1];
        for(int i=1; i<n;i++){
            prefixMax[i]=Math.max(prefixMax[i-1], height[i]);
        }
        for(int j=n-2; j>=0;j--){
            sufixMax[j]=Math.max(sufixMax[j+1], height[j]);
        }
        for(int i=0;i<n;i++){
            res += Math.min(prefixMax[i], sufixMax[i])-height[i];
        }
        return res;
    }
}
