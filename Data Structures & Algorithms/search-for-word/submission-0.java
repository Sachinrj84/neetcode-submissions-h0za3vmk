class Solution {
    Set<Pair<Integer, Integer>> set;
    int rows,cols;
    public boolean exist(char[][] board, String word) {
        set= new HashSet<>();
        rows=board.length;
        cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(i,j,word,0,board)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int r, int c, String word, int i, char[][] board){
        if(i==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=rows || c>=cols || word.charAt(i)!=board[r][c] || set.contains(new Pair<>(r,c))){
            return false;
        }
        set.add(new Pair<>(r,c));
        boolean res=dfs(r+1,c,word,i+1,board) ||dfs(r-1,c,word,i+1,board)||dfs(r,c+1,word,i+1,board)||dfs(r,c-1,word,i+1,board);
        set.remove(new Pair<>(r,c));
        return res;
    }
}
