class Solution {
        String[] digitschar= new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        List<String> res= new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(0,digits, "");
        return res;
    }
    public void backtrack(int i, String digits, String currStr){
        if(i==digits.length()){
            res.add(currStr);
            return;
        }

        String chars=digitschar[digits.charAt(i)-'0'];
        for(char c:chars.toCharArray()){
            backtrack(i+1,digits,currStr+c);
        }
    }
}
