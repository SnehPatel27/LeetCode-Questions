class DisjointSet{

    int size[];
    int parent[];

    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){

        if(node == parent[node]){
            return node;
        }

        int ultimateParent = findParent(parent[node]);
        parent[node] = ultimateParent;
        return ultimateParent;
    }

    public void unionBySize(int node1, int node2){

        int parentOfNode1 = findParent(node1);
        int parentOfNode2 = findParent(node2);

        if(parentOfNode1 == parentOfNode2){
            return;
        }

        if(size[parentOfNode2] > size[parentOfNode1]){
            parent[parentOfNode1] = parentOfNode2;
            size[parentOfNode2] += size[parentOfNode1];
        } else {
            parent[parentOfNode2] = parentOfNode1;
            size[parentOfNode1] += size[parentOfNode2];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        HashMap<String, Integer> mailIds = new HashMap<>();

        //Just Iterate over all the mailIds and assign Ids. 
        //For instance mailId: index
        //If you see that a mailId is repeated that mean we have spotted a user already before so just map the current user node with the one already seen user node. Like for instance in the first example John at index 1 gets mapped with john at index 0. So 1 becomes the child of 0 or vice versa. 
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mailId = accounts.get(i).get(j);
                if(mailIds.containsKey(mailId) == false){                    
                    mailIds.put(mailId, i);
                } else {
                    ds.unionBySize(mailIds.get(mailId), i);
                }
            }
        }

        //Merge all the mails based on the index in the hashMap.
        List<String>[] mergedMail = new ArrayList[n];

        for(int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<>();
        }

        for(String id: mailIds.keySet()){
            String mail = id;
            int node = ds.findParent(mailIds.get(mail));
            mergedMail[node].add(mail);
        }

        //You have the correct mailIds grouped together now so just add the person name before and then add the mailds associated with that person. 
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            
            for(String mail: mergedMail[i]){
                temp.add(mail);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }
}