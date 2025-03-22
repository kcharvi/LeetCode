class SmallestInfiniteSet {
    PriorityQueue<Integer> heap;
    // HashSet<Integer> set;
    int next;
    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        // for(int i=1; i<=1000; i++)
        //     heap.add(i);
        // set = new HashSet();
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