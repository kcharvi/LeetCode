class Solution {
    Map<String, String> id = new HashMap<>();
    Map<String, Double> w = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        for (List<String> eq : equations) {
            for (String elem : eq) {
                id.put(elem, elem);
                w.put(elem, 1.0);
            }
        }

        int N = equations.size();

        for (int i = 0; i < N; i++) {
            String q = equations.get(i).get(0);
            String p = equations.get(i).get(1);
            String root_q = find(q);
            String root_p = find(p);
            if (!root_q.equals(root_p)) {
                // If not in same set, then union
                id.put(root_q, p); // At each union, u is a direct child of root_q
                w.put(root_q, values[i]/w.get(q));
            }
        }

        // Flatten everything
        for (List<String> eq : equations)
            for (String u : eq) 
                find(u);

        double[] ret = new double[queries.size()];
        for (int i = 0; i < ret.length; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!id.containsKey(x) || !id.containsKey(y) || !find(x).equals(find(y)))
                ret[i] = -1.0;
            else
                ret[i] = w.get(x)/w.get(y);
        }

        // printState();

        return ret;
    }

    private void printState() {
        for (String key : id.keySet()) {
            System.out.printf("%s -> %s : %.2f; ", key, id.get(key), w.get(key));
        }
        System.out.println();
    }

    private String find(String u) {
        String v = id.get(u);
        // printState();
        if (!u.equals(v)) {
            // This flattens everything to the root on callback
            id.put(u, find(v));
            w.put(u, w.get(u) * w.get(v));
        }
        return id.get(u);
    }
}