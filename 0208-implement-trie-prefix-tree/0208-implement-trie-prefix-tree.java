class Trie {
    TrieNode node;
    public Trie() {
        this.node = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.node;
        char[] arr = word.toCharArray();
        for(Character ch : arr){
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.node;
        char[] arr = word.toCharArray();
        for(Character ch : arr){
            if(!curr.children.containsKey(ch))return false;
            curr = curr.children.get(ch);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.node;
        char[] arr = prefix.toCharArray();
        for(Character ch : arr){
            if(!curr.children.containsKey(ch))return false;
            curr = curr.children.get(ch);
        }
        return true;
    }
}
class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean endOfWord;
    public TrieNode(){
        this.children = new HashMap();
        this.endOfWord = false;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */