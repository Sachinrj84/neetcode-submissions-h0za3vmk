class Solution {
    Set<Pair<Integer,Integer>> pac;
    Set<Pair<Integer,Integer>> at;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res= new ArrayList<>();
        pac=new HashSet<>();
        at=new HashSet<>();
        int rows=heights.length;
        int cols=heights[0].length;
        
        for(int c=0;c<cols;c++){
            dfs(0,c,rows,cols,pac,heights[0][c],heights);
            dfs(rows-1,c,rows,cols,at,heights[rows-1][c],heights);
        }
        for(int r=0;r<rows;r++){
            dfs(r,0,rows,cols,pac,heights[r][0],heights);
            dfs(r,cols-1,rows,cols,at,heights[r][cols-1],heights);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pac.contains(new Pair(i,j)) && at.contains(new Pair(i,j))){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c,int rows,int cols, Set<Pair<Integer,Integer>> visit, int prevHeight, int[][] heights){
            if(r<0 || r==rows || c<0 || c==cols || visit.contains(new Pair(r,c))||heights[r][c]<prevHeight ){
                return;
            }
            visit.add(new Pair(r,c));
            dfs(r+1,c,rows,cols,visit,heights[r][c],heights);
             dfs(r-1,c,rows,cols,visit,heights[r][c],heights);
              dfs(r,c+1,rows,cols,visit,heights[r][c],heights);
               dfs(r,c-1,rows,cols,visit,heights[r][c],heights);
        }
}
