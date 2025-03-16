class Solution {

    Map<String, List<String>> adjList = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    List<String> currentPath = new ArrayList<>();

    public List<String> calculateNeighbors(String word, Set<String> wordList){

        List<String> neighbors = new ArrayList<>();
        
        for(int i = 0; i < word.length(); i++){
            char[] clonedWord = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++){
                clonedWord[i] = c;
                String newWord = new String(clonedWord);
                if(wordList.contains(newWord)){
                    neighbors.add(newWord);
                }
            }
        }

        return neighbors;
    }
    
    public void backtrack(String source, String destination){

        if(source.equals(destination)){
            List<String> path = new ArrayList<>(currentPath);
            Collections.reverse(path);
            result.add(path);
        }

        if(!adjList.containsKey(source)){
            return;
        }

        for(int i = 0; i < adjList.get(source).size(); i++){
            currentPath.add(adjList.get(source).get(i));
            backtrack(adjList.get(source).get(i), destination);
            currentPath.remove(currentPath.size() - 1);
        }

    }

    public void bfs(String beginWord, String endWord, Set<String> wordList){

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        if(wordList.contains(beginWord))
            wordList.remove(beginWord);
        
        Set<String> traversedWords = new HashSet<>();
        traversedWords.add(beginWord);

        while(!q.isEmpty()){
            
            List<String> visited = new ArrayList<>();

            int size = q.size();

            for(int i = 0; i < size; i++){
                String currentWord = q.remove();

                List<String> neighbors = calculateNeighbors(currentWord, wordList);

                if(currentWord.equals("hot")){
                    System.out.println(neighbors.size());
                }

                for(String word: neighbors){

                    visited.add(word);

                    if(!adjList.containsKey(word)){
                        adjList.put(word, new ArrayList<>());
                    }

                    adjList.get(word).add(currentWord);

                    if(!traversedWords.contains(word)){
                        traversedWords.add(word);
                        q.offer(word);
                    }

                }
            }
            for(String vistedWords: visited){
                if(wordList.contains(vistedWords))
                    wordList.remove(vistedWords);
            }
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordListClone = new HashSet<>(wordList);
        
        bfs(beginWord, endWord, wordListClone);
        
        currentPath.add(endWord);
        
        backtrack(endWord, beginWord);

        return result;
    }
}