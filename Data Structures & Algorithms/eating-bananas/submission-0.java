class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=Arrays.stream(piles).max().getAsInt();
        // for(int num: piles){
        //     maxPile=Math.max(maxPile, num);
        // }
        int res=maxPile;
        int l=1, r=maxPile;
        while(l<=r){
            int k=l+(r-l)/2;
            int totalTime=0;
            for(int p:piles){
                totalTime+= Math.ceil((double)p/k);
            }
            if(totalTime<=h){
                res=k;
                r=k-1;
            }else{
                l=k+1;
            }
        }
        return res;
        
    }
}
