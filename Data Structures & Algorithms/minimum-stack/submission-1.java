class MinStack {

    public Stack<Integer> st;
    public Stack<Integer> minst;

    public MinStack() {
        st= new Stack<>();
        minst= new Stack<>();
    }
    
    public void push(int val) {
        if(!st.isEmpty()){
            if(minst.peek()<val){
                minst.push(minst.peek());
            }else{
                minst.push(val);
            }
            st.push(val);
        }else{
        st.push(val);
        minst.push(val);
        }
    }
    
    public void pop() {
        st.pop();
        minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
