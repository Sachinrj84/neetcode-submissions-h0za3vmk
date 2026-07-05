class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList= new HashMap<>();
        for(int i=1;i<=n;i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] time:times){
            adjList.get(time[0]).add(new int[]{time[1],time[2]});
        }
        Set<Integer> visit= new HashSet<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,k});

        int t=0;
        while(!pq.isEmpty()){
            int[] node=pq.poll();
            if(visit.contains(node[1])){
                continue;
            }
            visit.add(node[1]);
            t=node[0];
            for(int[] edg:adjList.get(node[1])){
                int n2=edg[0], w2=edg[1];
                if(!visit.contains(n2)){
                    pq.offer(new int[]{node[0]+w2,n2});
                }
            }
        }
    return visit.size()==n ? t:-1;
        
    }
}
