class Solution {
    Set<Pair<Integer,Integer>> visit;
    Queue<Pair<Integer, Integer>> q;
    public void addroom(int r, int c, int rows, int cols, int[][] grid){
        if(r<rows && r>=0 && c<cols && c>=0 && !visit.contains(new Pair<>(r,c)) && grid[r][c]!=-1){
            q.offer(new Pair<>(r,c));
            visit.add(new Pair<>(r,c));
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        visit= new HashSet<>();
        q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    q.offer(new Pair<>(i,j));
                    visit.add(new Pair<>(i,j));
                }
            }
        }

        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair<Integer, Integer> room= q.poll();
                int r=room.getKey();
                int c=room.getValue();
                grid[r][c]=dist;
                addroom(r+1,c,rows, cols,grid);   
                addroom(r-1,c,rows, cols,grid);
                addroom(r,c+1,rows, cols,grid);
                addroom(r,c-1,rows, cols,grid);
            }
            dist+=1;
        }
    }
}
