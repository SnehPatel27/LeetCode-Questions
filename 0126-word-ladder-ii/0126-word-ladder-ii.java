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
        
        //This one is used to check that if the word has already been traversed we would no traverse it again. 
        Set<String> traversedWords = new HashSet<>();
        traversedWords.add(beginWord);

        while(!q.isEmpty()){
            
            //This keeps a track of the visited nodes in the same level.
            //At the end of traversing that level we would remove all the nodes in the visited from the wordList.
            List<String> visited = new ArrayList<>();

            int size = q.size();

            for(int i = 0; i < size; i++){
                String currentWord = q.remove();

                //Find the neighbors of the currentWord
                List<String> neighbors = calculateNeighbors(currentWord, wordList);

                for(String word: neighbors){

                    visited.add(word);

                    //Creating an adjList for the graph.
                    if(!adjList.containsKey(word)){
                        adjList.put(word, new ArrayList<>());
                    }

                    //We would be using a reverse graph in this case. That is the graph would go from the endWord to the beginWord. 
                    //The reason being. If we traverse from top to bottom we would also end up traversing the paths that do not lead to 
                    //the end word but in this case where we are traversing from the bottom to up. It is guranteed that that path would
                    //always lead to the endWord. So this would reduce the complexity of traversing the unecessary paths.
                    adjList.get(word).add(currentWord);

                    if(!traversedWords.contains(word)){
                        traversedWords.add(word);
                        q.offer(word);
                    }

                }
            } 

            //Removing all the visited words in a level from the wordlist. 
            for(String vistedWords: visited){
                if(wordList.contains(vistedWords))
                    wordList.remove(vistedWords);
            }
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordListClone = new HashSet<>(wordList);
        
        //Initially the BFS traversal is used to contrust the graph so that we can backtrack from it and find soln.
        bfs(beginWord, endWord, wordListClone);
        
        //The path always begin from the endWord.
        currentPath.add(endWord);
        
        //Find the paths.
        backtrack(endWord, beginWord);

        return result;
    }
}