// class Solution {
//     int max_product;
//     public long maxScore(int[] nums1, int[] nums2, int k) {

//         // Queue to store subsequence order
//         // Heap to return min element from nums 2
//         Deque<Integer> window = new ArrayDeque<>();
//         Deque<Integer> minheap = new ArrayDeque<>();

//         // Iterating subsequences
//         iterateSubsequences(nums1, nums2, 0, k, window, minheap);
//         return max_product;
//     }
//     void iterateSubsequences(int[] nums1, 
//                              int[] nums2, 
//                              int idx, 
//                              int k, 
//                              Deque<Integer> window,
//                              Deque<Integer> minheap){

//         if (window.size() == k){
//             int sum = 0;
//             for (int num : window)
//                 sum+=num;           
//             int min=Integer.MAX_VALUE;
//             for(int val: minheap)
//                 min=Math.min(min, val);

//             max_product = Math.max(max_product, sum*min);
//         }
//         for (int i = idx; i < nums1.length; i++) {
//             window.addLast(nums1[i]);    
//             minheap.addLast(nums2[i]);           
//             iterateSubsequences(nums1, nums2, i + 1, k, window, minheap);
//             window.removeLast();    
//             minheap.removeLast();              
//         }
//     }
// }

class Solution{
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pair = new int[n][2];
        for(int i=0; i<n; i++){
            pair[i][0] = nums1[i];
            pair[i][1] = nums2[i];
        }
        Arrays.sort(pair, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxProduct = 0;
        for(int i=0; i<n; i++){
            int val = pair[i][0];
            int min = pair[i][1];
            
            minHeap.add(val);
            sum += val;
            if(minHeap.size()>k)
                sum -= minHeap.poll();
            
            if (minHeap.size() == k) 
                maxProduct = Math.max(maxProduct, sum*min);
        }
        return maxProduct;
    }
}