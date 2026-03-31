class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newString= new StringBuilder();
        for( char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                newString.append(Character.toLowerCase(c));
            }
        }
        return newString.toString().equals(newString.reverse().toString());
    }
}
