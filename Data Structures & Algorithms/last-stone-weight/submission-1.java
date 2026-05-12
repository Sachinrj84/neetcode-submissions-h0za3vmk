class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(pq.size()!=1 && !pq.isEmpty()){
            int first=pq.poll();
            int sec=pq.poll();
            if(first==sec){
                continue;
            }else if(first>sec){
                pq.offer(first-sec);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
