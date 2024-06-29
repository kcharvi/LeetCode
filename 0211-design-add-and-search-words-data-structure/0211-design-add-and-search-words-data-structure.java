class WordDictionary {

   class Node{
       Node children[] = new Node[26];
       boolean eow = false;

       public Node(){
         for( int i = 0; i<26; i++){
            children[i] = null;
         }

       }
   }

   Node root;


    public WordDictionary() {

        root = new Node();
        
    }
    
    public void addWord(String word) {

      Node curr = root;

      for( int i = 0; i< word.length();i++){
        int idx = word.charAt(i)-'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new Node();
        }
       
       curr = curr.children[idx];


      }

      curr.eow = true;
        
    }
    
     public boolean search(String word) {

        return searchHelper(word , 0 , root);
      
    }

     private boolean searchHelper(String word, int index, Node curr) {
         
         if(index == word.length())
         {
            return curr.eow;
         }

        char ch = word.charAt(index);
 if(ch == '.'){
          
   for( int i = 0; i<26; i++){
     if(curr.children[i]!= null && searchHelper(word,  index +1,   curr.children[i]) ){
         return true;
     }

   }

   return false;

 }
 else{
    int idx = ch - 'a';

    if( curr.children[idx] == null){
        return false;
    }

    return searchHelper(word,  index +1,   curr.children[idx]);
 }



       
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */