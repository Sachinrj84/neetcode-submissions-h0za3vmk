class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visit;
    int res;
    public int countComponents(int n, int[][] edges) {
        adjList= new HashMap<>();
        visit= new HashSet<>();
        for(int i=0;i<n;i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edg:edges){
            adjList.get(edg[0]).add(edg[1]);
            adjList.get(edg[1]).add(edg[0]);
        }
        res=0;
        for(int i=0;i<n;i++){
            if(!visit.contains(i)){
                dfs(i);
                res=res+1;
            }
        }
        return res;
    }
    public void dfs(int v){
        if(visit.contains(v)){
            return;
        }
        visit.add(v);
        List<Integer> adj= adjList.get(v);
        int size= adj.size();
        for(int i=0;i<size;i++){
            dfs(adj.get(i));
        }
    }
}
