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
                dfs(i);
                res++;
            }
        }
        return res;
    }
    public void dfs(int i){
        visit.add(i);
        for(int nei:adjList.get(i)){
            if(!visit.contains(nei)){
                dfs(nei);
            }
        }
    }
}
