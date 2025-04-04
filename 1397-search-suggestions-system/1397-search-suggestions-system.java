class TrieNode{
    HashMap<Character, TrieNode> map;
    boolean endOfWord;
    TrieNode(){
        this.map = new HashMap<>();
        this.endOfWord = false;
    }
    HashMap<Character, TrieNode> getMap(){
        return this.map;
    }
    void setMap(HashMap<Character, TrieNode> hm){
        this.map = hm;
    }
    boolean getEoW(){
        return this.endOfWord;
    }
    void setEoW(boolean eow){
        this.endOfWord = eow;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        this.root = new TrieNode();
    }
    void insert(String word){
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.getMap().containsKey(ch)){
                curr.getMap().put(ch, new TrieNode());
            }
            curr = curr.getMap().get(ch);
        }
        curr.setEoW(true);
    }
    List<String> startsWith(String prefix){
        TrieNode curr = this.root;
        List<String> suggestProductsPrefix = new ArrayList();
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!curr.getMap().containsKey(ch))
                return suggestProductsPrefix;
            curr = curr.getMap().get(ch);   
        }
        collectWords(curr, new StringBuilder(prefix), suggestProductsPrefix);
        return suggestProductsPrefix;
    }
    void collectWords(TrieNode curr, StringBuilder prefixed, List<String> suggestProductsPrefix){
        if(suggestProductsPrefix.size() == 3)return;

        if(curr.getEoW())
            suggestProductsPrefix.add(prefixed.toString());
        
        List<Character> children = new ArrayList<>(curr.getMap().keySet());
        Collections.sort(children);
        for(char ch: children){
            prefixed.append(ch);
            collectWords(curr.getMap().get(ch), prefixed, suggestProductsPrefix);
            prefixed.deleteCharAt(prefixed.length() - 1); 
        }
    }

}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        //BUILD TRIE
        Trie node = new Trie();
        for(String prod : products)
            node.insert(prod);

        List<List<String>> ans = new ArrayList<>();
        //SEARCH TRIE
        for(int i=1; i<=searchWord.length(); i++)
            ans.add(node.startsWith(searchWord.substring(0,i)));

        return ans;
    }
}