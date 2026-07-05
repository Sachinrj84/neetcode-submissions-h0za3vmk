class Solution {
    Map<Integer, List<int[]>> adjList;
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        adjList= new HashMap<>();
        dist= new HashMap<>();
        for(int i=1;i<=n;i++){
            adjList.put(i, new ArrayList<>());
            dist.put(i,Integer.MAX_VALUE);
        }
        for(int[] time:times){
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }
        dfs(k,0);
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist.get(i)> res){
                res=dist.get(i);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;

    }
    public void dfs(int k, int time){
        if(time>=dist.get(k)) return;
        dist.put(k,time);
        if(!adjList.containsKey(k)) return;
        for(int[] edg: adjList.get(k)){
            dfs(edg[0],time+edg[1]);
        }
    }
}
