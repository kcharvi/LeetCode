class Solution {
    public double[] calcEquation(List<List<String>> equations, 
                                 double[] values, 
                                 List<List<String>> queries) {
        int number_of_queries = queries.size();   
        int number_of_equations = equations.size();                             
        double[] ans = new double[number_of_queries];
        Arrays.fill(ans, -1.0);

        // Store unique variables
        HashSet<String> set = new HashSet<>();
        for(List<String> list: equations){
            set.add(list.get(0));
            set.add(list.get(1));
        }

        // Build bidirectional graph with inverse values
        Map<String, List<String[]>> graph = new HashMap<>();
        for(int i=0; i<number_of_equations; i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];
            double inverse = 1.0 / value;
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(new String[]{to, String.valueOf(value)});
            graph.get(to).add(new String[]{from, String.valueOf(inverse)});
        } 

        int ans_idx = 0;
        for(List<String> query: queries){
            String numerator = query.get(0);
            String denominator = query.get(1);
            if(!set.contains(numerator) || !set.contains(denominator)){
                ans_idx++;
                continue; 
            }
            else if(numerator.equals(denominator)) {
                ans[ans_idx++] = 1.0;   
            }
            else{
                Set<String> visited = new HashSet<>();
                ans[ans_idx++] = dfs(graph, numerator, denominator, 1.0, visited);
            }
        }
        return ans;
    }
    double dfs(Map<String, List<String[]>> graph, 
               String currentNode, 
               String targetNode, 
               double product,
               Set<String> visited){
        if(currentNode.equals(targetNode))
            return product;

        visited.add(currentNode);
        if(!graph.containsKey(currentNode))
            return -1.0;
        
        for(String[] neighbor: graph.get(currentNode)){
            String nextNode = neighbor[0];
            double weight = Double.parseDouble(neighbor[1]);
            if(!visited.contains(nextNode)){
                double result = dfs(graph, nextNode, targetNode, product*weight, visited);
                if(result!=-1.0)
                    return result;
            }
        }
        return -1.0;

    }
}