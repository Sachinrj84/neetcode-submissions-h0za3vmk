class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visit;
    public int countComponents(int n, int[][] edges) {
        adjList= new HashMap<>();
        visit= new HashSet<>();
        for(int i=0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int[] edg:edges){
            adjList.get(edg[0]).add(edg[1]);
            adjList.get(edg[1]).add(edg[0]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(!visit.contains(i)){
                bfs(i);
                res++;
            }
        }
        return res;
    }
    public void bfs(int i){
        Queue<Integer> q= new LinkedList<>();
        q.offer(i);
        visit.add(i);
        while(!q.isEmpty()){
            int v=q.poll();
            List<Integer> adj=adjList.get(v);
            int size=adj.size();
            for(int j=0;j<size;j++){
                if(!visit.contains(adj.get(j))){
                    q.offer(adj.get(j));
                    visit.add(adj.get(j));
                }
            }
        }
    }
}
