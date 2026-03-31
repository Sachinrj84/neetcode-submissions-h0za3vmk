class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeIcon= new HashMap<>();
        closeIcon.put(')', '(');
        closeIcon.put('}', '{');
        closeIcon.put(']', '[');
        char[] schar=s.toCharArray();
        Stack<Character> st= new Stack<>();

        for(char sc:schar){
            if(!st.isEmpty() && closeIcon.containsKey(sc)){
                if(  st.peek()==closeIcon.get(sc)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(sc);
            }
        }
        return st.isEmpty();

    }
}
