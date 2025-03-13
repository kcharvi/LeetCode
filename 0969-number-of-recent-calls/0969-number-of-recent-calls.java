class RecentCounter {
    Queue<Integer> requests;
    public RecentCounter() {
        this.requests = new ArrayDeque();
    }
    
    public int ping(int t) {
        requests.add(t);
        while (requests.peek() != null && requests.peek() + 3000 < t) {
            requests.poll();
        }
        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */