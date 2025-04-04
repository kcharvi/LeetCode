class TrieNode{
    HashMap<Character, TrieNode> map = new HashMap();
    boolean endOfWord = false;
    TrieNode(){
        this.map = new HashMap();
        this.endOfWord = false;
    }
    HashMap<Character, TrieNode> getMap(){
        return this.map;
    }
    boolean getEoW(){
        return this.endOfWord;
    }
    void setMap(HashMap map){
        this.map = map;
    }
    void setEoW(boolean EoW){
        this.endOfWord = EoW;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){ 
            char ch = word.charAt(i);
            if(!curr.getMap().containsKey(ch))
                curr.getMap().put(ch, new TrieNode());
            curr = curr.getMap().get(ch);
        }
        curr.setEoW(true);
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.getMap().containsKey(ch))
                return false;
            curr = curr.getMap().get(ch);
        }
        return curr.getEoW();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!curr.getMap().containsKey(ch))
                return false;
            curr = curr.getMap().get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */