class Solution {
    Queue<Pair<Integer,Integer>> q;
    Set<Pair<Integer,Integer>> visit;
    public int orangesRotting(int[][] grid) {
        q= new LinkedList<>();
        visit= new HashSet<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int fresh=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair<>(i,j));
                    visit.add(new Pair<>(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int res=bfs(rows,cols,grid, fresh);
        return res;
    }
    public int addfruit(int r, int c, int rows, int cols, int[][] grid){
        if(r<rows && r>=0 && c<cols && c>=0 && !visit.contains(new Pair<>(r,c)) && grid[r][c]==1){
            q.offer(new Pair<>(r,c));
            visit.add( new Pair<>(r,c));
            grid[r][c]=2;
            return 1;
        }
        return 0;
    }
    public int bfs(int rows, int cols, int[][] grid, int fresh){
        int min=0;
        while(fresh > 0 && !q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair<Integer, Integer> fr= q.poll();
                int r=fr.getKey();
                int c=fr.getValue();
                fresh -= addfruit(r+1,c,rows,cols,grid);
                fresh -=addfruit(r-1,c,rows,cols,grid);
                fresh -= addfruit(r,c+1,rows,cols,grid);
                fresh -= addfruit(r,c-1,rows,cols,grid);
            }
            min++;

        }
        return fresh==0?min:-1;
    }
}
