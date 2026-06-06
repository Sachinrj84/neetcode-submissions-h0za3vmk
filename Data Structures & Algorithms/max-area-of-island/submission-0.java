class Solution {
    int res;
    Set<Pair<Integer,Integer>> visit;
    public int maxAreaOfIsland(int[][] grid) {
        res=0;
        visit= new HashSet<>();
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !visit.contains(new Pair(i,j))){
                    bfs(i,j,rows,cols,grid);
                }
            }
        }
        return res;
    }
    public void bfs(int i, int j, int rows, int cols, int[][] grid){
        Queue<Pair<Integer, Integer>> q= new LinkedList<>();
        q.add(new Pair(i,j));
        visit.add(new Pair(i,j));
        int area=1;
        while(!q.isEmpty()){
            Pair<Integer, Integer> node=q.poll();
            int r=node.getKey();
            int c=node.getValue();
            int[][] directions= {{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] dir:directions){
                int row=dir[0]+r;
                int col=dir[1]+c;
                if(row<rows && row>=0 && col<cols && col>=0 && grid[row][col]==1 && !visit.contains(new Pair(row,col))){
                    q.offer(new Pair(row,col));
                    visit.add(new Pair(row,col));
                    area+=1;
                }
            }
        }
        if(res<area){
            res=area;
        }
    }
}
