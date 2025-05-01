//In this while inserting into the heap it is very important to follow the order. 
//So in this case. My all elements in maxHeap would always be less then all elements in minHeap.
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> (b - a));
    }
    
    public void addNum(int num) {
        //First I insert into the maxHeap and then I pull out the maximum and insert that into the minHeap and then if the size of the maxHeap becomes less then the size of the minHeap then i poll from the minHeap and insert it into the maxHeap.
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {    
        int minHeapSize = minHeap.size();
        int maxHeapSize = maxHeap.size();

        if((minHeapSize + maxHeapSize) % 2 == 0){
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */