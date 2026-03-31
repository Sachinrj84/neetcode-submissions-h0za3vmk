class Solution {
    public int maxProfit(int[] prices) {
        int res=0, l=0, r=1;
        while(r<prices.length){
            if(prices[r]>prices[l]){
                res= Math.max(res, prices[r]-prices[l]);
                r++;
            }else{
                l=r;
                r++;
            }
        }
        return res;
    }
}
