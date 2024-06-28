import java.util.*;

class Solution {
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    HashMap<String, Map<String, Double>> adjmap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        for (List<String> str : equations) {
            String a = str.get(0);
            String b = str.get(1);

            adjmap.putIfAbsent(a, new HashMap<>());
            adjmap.putIfAbsent(b, new HashMap<>());

            adjmap.get(a).put(b, values[i]);
            adjmap.get(b).put(a, 1 / values[i]);
            i++;
        }

        double[] ans = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            ans[j] = bfs(queries.get(j).get(0), queries.get(j).get(1));
        }
        return ans;
    }

    public double bfs(String src, String target) {
        if (!adjmap.containsKey(src) || !adjmap.containsKey(target)) return -1.0;
        if (src.equals(target)) return 1.0;

        Queue<Pair<String, Double>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new Pair<>(src, 1.0));
        visited.add(src);

        while (!q.isEmpty()) {
            Pair<String, Double> curr = q.poll();
            String currNode = curr.getKey();
            Double currValue = curr.getValue();

            if (currNode.equals(target)) {
                return currValue;
            }

            Map<String, Double> neighbors = adjmap.get(currNode);
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String neighbor = entry.getKey();
                Double weight = entry.getValue();

                if (!visited.contains(neighbor)) {
                    q.add(new Pair<>(neighbor, currValue * weight));
                    visited.add(neighbor);
                }
            }
        }

        return -1.0;
    }
}
