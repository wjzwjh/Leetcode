class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(max.size() < min.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()) {
            return ((double)max.peek() + (double)min.peek()) / 2;
        }else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
