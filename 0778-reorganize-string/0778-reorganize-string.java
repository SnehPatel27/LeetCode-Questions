class Solution {
    public String reorganizeString(String s) {
        int charCounts[] = new int[26];
        for(char c: s.toCharArray()){
            charCounts[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < 26; i++){
            if(charCounts[i] > 0)
                pq.offer(new int[]{(char)i + 'a', charCounts[i]});
        }

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            int first[] = pq.poll();
            if(res.isEmpty() || first[0] != res.charAt(res.length() - 1)){
                res.append((char)first[0]);
                if(--first[1] > 0){
                    pq.offer(first);
                }
            } else {
                if(pq.isEmpty()) return "";

                int[] second = pq.poll();
                res.append((char)second[0]);
                if(--second[1] > 0){
                    pq.offer(second);
                }

                pq.offer(first);
            }
        }

        return res.toString();
    }

    /* Time Complexity - Counting freq of char - O(N), Appending in pq takes O(logK) so in the worst case it would be 26 chars
so O(1), Processing the PQ - Since the total number of insertions and removals is proportional to the number of characters   in the string (n), this step is bounded by O(n log k).
  */ /* Space Complexity - Character Frequency Array: O(26) = O(1), PriorityQueue: O(k) PriorityQueue stores at most k elements, where k is the number of distinct characters in the string, StringBuilder: O(n).
    
    Time Complexity: O(n + n log k)
    Space Complexity: O(n + k) */
}