class MedianFinder {
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;

    public MedianFinder() {
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minQ.add(num);
        maxQ.add(minQ.poll());
        
        if (maxQ.size() - minQ.size() > 1) {
            minQ.add(maxQ.poll());
        }
    }
    
    public double findMedian() {
        return maxQ.size() == minQ.size() ? (minQ.peek() + maxQ.peek()) / 2.0 : maxQ.peek(); 
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */