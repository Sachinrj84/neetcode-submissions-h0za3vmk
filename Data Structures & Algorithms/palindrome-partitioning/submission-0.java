class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        List<String> part= new ArrayList<>();
        dfs(0,part,s);
        return res;
    }
    public void dfs(int i, List<String> part, String s){
        if(i>=s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPali(s,i,j)){
                part.add(s.substring(i,j+1));
                dfs(j+1,part,s);
                part.remove(part.size()-1);
            }
        }
    }
    public boolean isPali(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
