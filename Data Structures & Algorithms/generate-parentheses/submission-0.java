class Solution {
    List<String> res;
    StringBuilder st;
    public List<String> generateParenthesis(int n) {
        res= new ArrayList<>();
        st= new StringBuilder();
        backtrack(0,0,n);
        return res;
    }
    public void backtrack(int openN, int closedN, int n){
        if(openN==closedN && closedN==n){
            res.add(st.toString());
            return;
        }
        if(openN<n){
            st.append('(');
            backtrack(openN+1,closedN,n);
            st.deleteCharAt(st.length()-1);
        }
        if(closedN<openN){
            st.append(')');
            backtrack(openN,closedN+1,n);
            st.deleteCharAt(st.length()-1);
        }
    }
}
