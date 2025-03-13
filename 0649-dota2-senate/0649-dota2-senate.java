class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();
            if (radiantIndex < direIndex) {
                radiantQueue.add(radiantIndex + n);
            } else {
                direQueue.add(direIndex + n);
            }
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";

    }
}