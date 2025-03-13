class Solution {
    public int numTilePossibilities(String tiles) {
        
        Set<String> result = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        findAllPossibilities(tiles, used, result, "");
        return result.size() - 1;
        
    }

    public void findAllPossibilities(String tiles, boolean[] used, Set<String> result, String currentString){

        result.add(currentString);

        for(int i = 0; i < tiles.length(); i++){
            if(!used[i]){
                used[i] = true;
                findAllPossibilities(tiles, used, result, currentString + tiles.charAt(i));
                used[i] = false;
            }
        }
    }
}