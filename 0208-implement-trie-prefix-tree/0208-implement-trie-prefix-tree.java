class TrieNode{

    private TrieNode[] links;
    private boolean flag;
    
    TrieNode(){
        this.flag = false;
        this.links = new TrieNode[26];
    }

    public boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    public void put(char c, TrieNode node){
        links[c - 'a'] = node;
    }

    public TrieNode getNext(char c){
        return links[c - 'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean checkEnd(){
        return flag == true;
    }

}

class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word) {

        TrieNode head = root;

        for(int i = 0; i < word.length(); i++){
            if(!head.containsKey(word.charAt(i))){
                head.put(word.charAt(i), new TrieNode());
            }

            head = head.getNext(word.charAt(i));
        }

        head.setEnd();

    }
    
    public boolean search(String word) {

        TrieNode head = root;

        for(int i = 0; i < word.length(); i++){
            if(!head.containsKey(word.charAt(i))){
                return false;
            }

            head = head.getNext(word.charAt(i));
        }

        return head.checkEnd();
        
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode head = root;

        for(int i = 0; i < prefix.length(); i++){
            if(!head.containsKey(prefix.charAt(i))){
                return false;
            }

            head = head.getNext(prefix.charAt(i));
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