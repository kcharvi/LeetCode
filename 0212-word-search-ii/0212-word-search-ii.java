class Node {
    private Node[] links;
    private boolean wordEnd;

    public Node() {
        links = new Node[26];
        wordEnd = false;
    }

    public boolean isNull(int ind) {
        return links[ind] == null;
    }

    public void put(int ind, Node node) {
        links[ind] = node;
    }

    public Node get(int ind) {
        return links[ind];
    }

    public void setEnd() {
        wordEnd = true;
    }

    public void unSetEnd() {
        wordEnd = false;
    }

    public boolean isEnd() {
        return wordEnd;
    }
}


class Solution {
    private int[] Y = {-1, 0, 1, 0};
    private int[] X = {0, -1, 0, 1};

    private void insert(String word, Node node) {
        for (char ch : word.toCharArray()) {
            int ind = ch - 'a';
            if (node.isNull(ind)) {
                node.put(ind, new Node());
            }
            node = node.get(ind);
        }
        node.setEnd();
    }

    private void checkWord(int i, int j, char[][] board, boolean[][] vis, List<String> res, Node node, String s) {
        if (node.isEnd()) {
            res.add(s);
            node.unSetEnd();
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j]) return;

        vis[i][j] = true;
        int ind = board[i][j] - 'a';
        if (!node.isNull(ind)) {
            for (int k = 0; k < 4; k++) {
                int ii = i + X[k];
                int jj = j + Y[k];
                checkWord(ii, jj, board, vis, res, node.get(ind), s + board[i][j]);
            }
        }

        vis[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length, cols = board[0].length;
        List<String> res = new ArrayList<>();
        boolean[][] vis = new boolean[rows][cols];

        Node root = new Node();
        for (String word : words) {
            insert(word, root);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!root.isNull(board[i][j] - 'a')) {
                    checkWord(i, j, board, vis, res, root, "");
                }
            }
        }

        return res;
    }
}