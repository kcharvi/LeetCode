class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<int[]> projects = new ArrayList();
        for(int i=0;i<capital.length;i++)
            projects.add(new int[]{capital[i], profits[i]});
        projects.sort((a1, a2) -> Integer.compare(a1[0], a2[0]));

        int j=0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        while(k-- > 0){
            while(j<profits.length && projects.get(j)[0]<=w){
                    heap.add(projects.get(j)[1]);
                    j++;
                }
            if(heap.isEmpty())break;
            w+=heap.poll();
        }
        return w;
    }
}