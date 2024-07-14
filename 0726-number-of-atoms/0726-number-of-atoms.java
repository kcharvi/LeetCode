class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stk = new Stack();
        stk.push(new HashMap<>());
        int n = formula.length();
        int i = 0;
        while(i<n){
            if(formula.charAt(i) == '('){
                stk.push(new HashMap<String, Integer>());
                i++;
            }
            else if(formula.charAt(i) == ')'){
                Map<String, Integer> top = stk.pop();
                i++;
                int start = i;
                while(i<n && Character.isDigit(formula.charAt(i)))i++;
                int count = start<i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for(String key: top.keySet())
                    stk.peek().put(key, stk.peek().getOrDefault(key, 0)+ top.get(key) * count);
            }
            else{
                int start = i;
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i)))i++;
                String ele = formula.substring(start , i);
                start = i;
                while(i<n && Character.isDigit(formula.charAt(i)))i++;
                int count = start<i ? Integer.parseInt(formula.substring(start, i)): 1;
                stk.peek().put(ele, stk.peek().getOrDefault(ele, 0)+ count);
            }
        }
        Map<String, Integer> ans = stk.pop();
        List<String> elements = new ArrayList<>(ans.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for(String ele : elements){
            sb.append(ele);
            int count = ans.get(ele);
            if(count>1)sb.append(count);
        }
        return sb.toString();
    }
}