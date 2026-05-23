class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        this.maxHeap= new PriorityQueue<>((a,b)->b-a);
        this.minHeap= new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size()-minHeap.size()>1 || !minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return ((double)(minHeap.peek()+maxHeap.peek())/2.0);
        }else
        if(minHeap.size()>maxHeap.size()){
            return (double)minHeap.peek();
        }else {
            return (double)maxHeap.peek();
        }
    }

}
