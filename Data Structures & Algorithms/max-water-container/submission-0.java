class Solution {
    public int maxArea(int[] heights) {
        int res=0;
        for ( int i=0; i<heights.length-1; i++){
            for( int j=i+1; j< heights.length; j++){
                if(heights[i]<=heights[j]){
                    int cal= heights[i]*(j-i);
                    if(res<cal){
                        res=cal;
                    }
                }else{
                    int cal2= heights[j]*(j-i);
                    if(res< cal2){
                        res=cal2;
                    }
                }
            }
        }
        return res;
    }
}
