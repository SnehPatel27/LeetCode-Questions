class Pair{
    String word;
    int steps;

    Pair(String first, int second){
        this.word = first;
        this.steps = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> words = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            words.add(wordList.get(i));
        }

        if(!words.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        words.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().steps;

            System.out.println(word);

            q.remove();

            if(word.equals(endWord)) return step;

            for(int i = 0; i < word.length(); i++){
                char[] replacedCharArray = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(words.contains(replacedWord)){
                        System.out.println(replacedWord);
                        q.offer(new Pair(replacedWord, step + 1));
                        words.remove(replacedWord);
                    }
                }
            }
        }

        return 0;
    }
}