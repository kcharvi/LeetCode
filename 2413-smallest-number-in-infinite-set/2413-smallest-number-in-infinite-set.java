class SmallestInfiniteSet {
    PriorityQueue<Integer> heap;
    int next;
    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        next = 1;   
    }
    
    public int popSmallest() {
        if(!heap.isEmpty())
            return heap.poll();
        return next++;
    }
    
    public void addBack(int num) {
        if (num < next  && !heap.contains(num)) {
            heap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */