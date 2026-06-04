class Solution {
    List<List<String>> res;
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    public List<List<String>> solveNQueens(int n) {
        res= new ArrayList<>();
        cols= new HashSet<>();
        posDiag=new HashSet<>();
        negDiag=new HashSet<>();
        char[][] board= new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        backtrack(0,board,n);
        return res;
    }
    public void backtrack(int r, char[][] board, int n){
        if(r==n){
            List<String> copy= new ArrayList<>();
            for(char[] row:board){
                copy.add( new String(row));
            }
            res.add(copy);
            return;
        }
        for(int c=0;c<n;c++){
            if(cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }
            board[r][c]='Q';
            cols.add(c);
            negDiag.add(r-c);
            posDiag.add(r+c);
            backtrack(r+1,board,n);
            board[r][c]='.';
            cols.remove(c);
            negDiag.remove(r-c);
            posDiag.remove(r+c);
        }
    }
}
