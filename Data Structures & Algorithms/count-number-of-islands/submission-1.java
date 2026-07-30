class Solution {
    public int[][] directions= {{0,-1},{0,1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int res=0;
        int r=grid.length, c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    res+=1;
                    bfs(i,j,grid);
                }
            }
        }
        return res;
    }
    public void bfs(int r, int c, char[][] grid){
        int gr=grid.length, gc=grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{r,c});
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] node=q.poll();
            int nr=node[0], nc=node[1];
            for(int[] dir:directions){
                if(dir[0]+nr <gr && dir[1]+nc<gc && dir[0]+nr >=0 && dir[1]+nc >=0 && grid[dir[0]+nr][dir[1]+nc]=='1'){
                    q.add(new int[]{dir[0]+nr, dir[1]+nc});
                    grid[dir[0]+nr][dir[1]+nc]='0';
                }
            }
        }
    }
}
