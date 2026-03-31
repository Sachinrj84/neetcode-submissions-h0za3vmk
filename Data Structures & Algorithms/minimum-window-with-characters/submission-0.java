class Solution {
    public String minWindow(String s, String t) {
        int sl=s.length();
        int tl=t.length();
        int resLen = Integer.MAX_VALUE;
        int[] res={-1,-1};
        Map<Character, Integer> countT= new HashMap<>();
        for(char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c,0)+1);
        }
        for(int i=0; i< s.length(); i++){
            HashMap<Character, Integer> ha= new HashMap<>();
            for(int j=i ; j<s.length(); j++){
                ha.put(s.charAt(j), ha.getOrDefault(s.charAt(j),0)+1);
                boolean flag=true;
                for(char c: countT.keySet()){
                    if(ha.getOrDefault(c,0) < countT.get(c)){
                        flag=false;
                        break;
                    }
                }
                if(flag && (j-i+1)<resLen){
                    resLen=j-i+1;
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return resLen==Integer.MAX_VALUE? "":s.substring(res[0], res[1]+1);
    }
}
