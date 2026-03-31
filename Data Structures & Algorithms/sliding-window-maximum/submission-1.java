class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

    
    for (int i = 0; i < k; i++) {
        pq.offer(nums[i]);
    }
    res[0] = pq.peek();
    for (int i = k; i < nums.length; i++) {
        pq.remove(nums[i - k]); 
        pq.offer(nums[i]);       
        res[i - k + 1] = pq.peek();
    }

    return res;
    }
}
