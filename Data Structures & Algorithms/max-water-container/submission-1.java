class Solution {
    public int maxArea(int[] heights) {
        int res=0;
        int l=0;
        int r=heights.length-1;
        while(l<r){
            int area=Math.min(heights[l], heights[r])*(r-l);
            if(heights[l]<=heights[r]){
                l++;
            }else{
                r--;
            }
            if(res<area){
                res=area;
            }
        }
        return res;

    }
}
