class MedianFinder {
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;

    public MedianFinder() {
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxQ.size() == minQ.size()) {
            maxQ.add(num);
        } else {
            minQ.add(num);
        }
        
        while (maxQ.size() > 0 && 
               minQ.size() > 0 &&
               maxQ.peek() > minQ.peek()) {
            Integer maxValue = maxQ.poll();
            Integer minValue = minQ.poll();
            maxQ.add(minValue);
            minQ.add(maxValue);
        }
    }
    
    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
            return ((double) maxQ.peek() + minQ.peek()) / 2;
        }
        return (double) maxQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */