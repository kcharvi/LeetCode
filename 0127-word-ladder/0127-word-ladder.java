class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));

        Set<String> st=new HashSet<String>();  // arrayList me search krne ki time compexity O(N)
        // set me .contains ki Time Complexity O(1)..
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }

        st.remove(beginWord); // to mark this as visited so we remove it from set
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();

            if(word.equals(endWord)==true) { // if we get the end word then return the steps
                return steps;
            }

            for(int i=0;i<word.length();i++){ 
                char[] containLetterArray=word.toCharArray();

                for(char j='a';j<='z';j++){
                    containLetterArray[i]=j;
                    String changeWord=new String(containLetterArray);

                    if(st.contains(changeWord)){
                        q.add(new Pair(changeWord,steps+1));
                        st.remove(changeWord);
                    }

                }
            }
        }

        return 0;

        
    }
}