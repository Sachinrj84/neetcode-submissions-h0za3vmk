class Solution {
    List<int[]>[] adjList;
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        adjList= new ArrayList[n+1];
        dist= new HashMap<>();
        for(int i=1;i<=n;i++){
            adjList[i]= new ArrayList<>();
            dist.put(i,Integer.MAX_VALUE);
        }
        for(int[] time:times){
            adjList[time[0]].add(new int[]{time[1], time[2]});
        }
        bfs(k,0);
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist.get(i)> res){
                res=dist.get(i);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;

    }
    public void bfs(int k, int time){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{k,time});
        dist.put(k,0);
        while(!q.isEmpty()){
            int[] node=q.poll();
            int n1=node[0], t1=node[1];
            if(dist.get(n1)<t1){
                continue;
            }
            for(int[] nei:adjList[n1]){
                int n2=nei[0], t2=nei[1];
                if(t2+t1<dist.get(n2)){
                    dist.put(n2, t1+t2);
                    q.offer(new int[]{n2, t1+t2});
                } 
            }
        }
    }
}
