class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] comb= new int[n][2];
        for(int i=0; i<n;i++){
            comb[i][0]=position[i];
            comb[i][1]=speed[i];
        }
        Arrays.sort(comb, (a,b)-> Integer.compare(b[0],a[0]));
        Stack<Double> st= new Stack<>();
        for(int[] p:comb){
            st.push((double) (target-p[0])/p[1]);
            if(st.size()>=2 && st.peek() <= st.get(st.size()-2)){
                st.pop();
            }
        }
        return st.size();
    }
}
