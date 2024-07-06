import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1])
        );

        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        // Initialize the heap with the first element in nums2 paired with every element in nums1
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.add(new int[] {nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            ans.add(Arrays.asList(cur[0], cur[1]));

            if (cur[2] == nums2.length - 1) continue; // If there are no more elements in nums2 to pair with cur[0]

            minHeap.add(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return ans;
    }
}
