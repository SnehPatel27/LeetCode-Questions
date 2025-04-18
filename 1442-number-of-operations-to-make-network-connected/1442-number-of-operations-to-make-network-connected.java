class DisjointSet{

    int[] size;
    int[] parent;

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
        return ultimateParent; // Or could return parent.get(node);
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

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraCables = 0;

        for(int i[]: connections){

            int parent1 = ds.findParent(i[0]);
            int parent2 = ds.findParent(i[1]);

            if(parent1 == parent2){
                extraCables++;    
            } else{
                //Directly connect the parents itself so that it can be more optimzed and reduct the future parentCalls. 
                ds.unionBySize(parent1, parent2);
            }
        }

        //Check for the connected Components
        Set<Integer> connectedComponents = new HashSet<>();
        for(int i = 0; i < n; i++){ 
            connectedComponents.add(ds.findParent(i));
        }

        if(extraCables >= connectedComponents.size() - 1){
            return connectedComponents.size() - 1;
        }

        return -1;
    }
}