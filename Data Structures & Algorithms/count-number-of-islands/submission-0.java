class Solution {
        Set<Pair<Integer,Integer>> visit= new HashSet<>();
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int islands=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !visit.contains(new Pair(i,j))){
                    bfs(i,j,grid, r, c);
                    islands+=1;
                }
            }
        }
        return islands;
    }
    public void bfs(int i, int j, char[][] grid, int row, int col){
        Queue<Pair<Integer, Integer>> q= new LinkedList<>();
        q.add(new Pair(i,j));
        visit.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair<Integer, Integer> pair=q.poll();
            int f=pair.getKey();
            int s=pair.getValue();
            int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] dir:directions){
                int r=f+dir[0];
                int c=s+dir[1];
                if(r<row && r>=0 && c<col && c>=0 && !visit.contains(new Pair(r,c)) && grid[r][c]=='1'){
                    q.add(new Pair(r,c));
                    visit.add(new Pair(r,c));
                }
            }
        }
    }
}
