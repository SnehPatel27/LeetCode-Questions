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
    public int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < stones.length; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }   

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for(int i = 0; i < stones.length; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            ds.unionBySize(nodeRow, nodeCol);

            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int count = 0;

        for(int i: stoneNodes.keySet()){
            if(ds.findParent(i) == i){
                count++;
            }
        }

        return stones.length - count;
    }
}