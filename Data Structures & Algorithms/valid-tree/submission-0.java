class Solution {
    Map<Integer,List<Integer>> adjList;
    Set<Integer> visit;
    public boolean validTree(int n, int[][] edges) {
        adjList= new HashMap<>();
        visit= new HashSet<>();
        for(int i=0;i<n;i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edg:edges){
            adjList.get(edg[0]).add(edg[1]);
            adjList.get(edg[1]).add(edg[0]);
        }
        return dfs(0,-1) && n==visit.size();
    }

    public boolean dfs(int v, int preV){
        if(visit.contains(v)) return false;
        visit.add(v);
        List<Integer> adj= adjList.get(v);
        int size= adj.size();
        for(int i=0;i<size;i++){
            if(adj.get(i)==preV){
                continue;
            } 
            if(!dfs(adj.get(i),v)) return false;
        }
        return true;
    }
}
