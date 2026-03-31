class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res= new int[k];
        int j=0;
        Map<Integer, Integer> map= new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        }
        PriorityQueue<int[]> heap= new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            heap.offer(new int[]{e.getValue(), e.getKey()});
            if(heap.size()>k){
                heap.poll();
            }
        }
        for(int i=0;i<k;i++){
            res[i]=heap.poll()[1];
        }
        return res;
    }
}
