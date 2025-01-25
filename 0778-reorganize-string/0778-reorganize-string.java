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
}