class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<stones.length;i++){
            pq.offer(-stones[i]);
        }
        while(pq.size()!=1 && !pq.isEmpty()){
            int first=pq.poll();
            int sec=pq.poll();
            if(first==sec){
                continue;
            }else if(first<sec){
                pq.offer(first-sec);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
