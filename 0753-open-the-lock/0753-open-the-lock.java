class Solution {
    static class Pair{
        String current;
        int steps;
        Pair(String current, int steps){
            this.current = current;
            this.steps = steps;
        }
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for(String i: deadends){
            visited.add(i);
        }

        if(visited.contains("0000") || visited.contains(target))
            return -1;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair("0000", 0));
        visited.add("0000");

        while(!q.isEmpty()){

            int size = q.size();
            System.out.println(size);

            for(int j = 0; j < size; j++){
                Pair p = q.remove();
                String temp = p.current;
                int steps = p.steps;

                if(temp.equals(target)){
                    return steps;
                }

                for(String i: possibleCombinations(temp, visited)){
                    visited.add(i);
                    q.offer(new Pair(i, steps + 1));
                }
            }
        }

        return -1;
    }

    public List<String> possibleCombinations(String temp, HashSet<String> visited){
        List<String> neighbors = new ArrayList<>();
        char[] word = temp.toCharArray();
        for(int i = 0; i < 4; i++){
            char original = word[i];

            //Increment by 1 and wrap 9 to 0
            word[i] = (char)(((original - '0' + 1) % 10) + '0');
            String newWord = new String(word);
            if(!visited.contains(newWord)){
                neighbors.add(newWord);
            }

            word[i] = original;

            //Decrement by 1 and wrap 0 to 9
            word[i] = (char)(((original - '0' + 9) % 10) + '0');
            newWord = new String(word);
            if(!visited.contains(newWord)){
                neighbors.add(newWord);
            }

            word[i] = original;
        }

        return neighbors;
    }
}