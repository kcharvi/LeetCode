class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse the array twice to simulate the circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n]; // Use modulo to simulate circular array
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num; // Update the result for the top element
            }
            if (i < n) {
                stack.push(i); // Push the current index (only for the first pass)
            }
        }

        return result;
    }
}