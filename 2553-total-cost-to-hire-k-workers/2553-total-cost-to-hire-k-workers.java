class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long totalcost = 0;
        PriorityQueue<Integer> minHeapFirstHalf = new PriorityQueue();
        PriorityQueue<Integer> minHeapSecondHalf = new PriorityQueue();
        int i=0; 
        int j=costs.length-1;
        while(i<=j && minHeapFirstHalf.size()<candidates)
            minHeapFirstHalf.add(costs[i++]);
        while(i<=j && minHeapSecondHalf.size()<candidates)
            minHeapSecondHalf.add(costs[j--]);
        
        for(int session = 0; session<k; session++){
            if(minHeapSecondHalf.isEmpty() || (!minHeapFirstHalf.isEmpty() &&
                                                minHeapFirstHalf.peek() <= minHeapSecondHalf.peek())){
                totalcost+=minHeapFirstHalf.poll();
                if(i<=j)
                    minHeapFirstHalf.offer(costs[i++]);
            }
            else{
                totalcost+=minHeapSecondHalf.poll();
                if(i<=j)
                    minHeapSecondHalf.offer(costs[j--]);
            }
        }
        return totalcost;
    }
}