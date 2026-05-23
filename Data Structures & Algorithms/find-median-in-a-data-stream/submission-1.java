class MedianFinder {
    List<Integer> arr;

    public MedianFinder() {
        this.arr=new ArrayList<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        Collections.sort(arr);
        int n= arr.size();
        double res;
        if(n%2!=0){
            return arr.get(n/2);
        }
        int num=n/2;
        int sum=(arr.get(num-1)+arr.get(num));
        return (double)sum/2;
    }
}
