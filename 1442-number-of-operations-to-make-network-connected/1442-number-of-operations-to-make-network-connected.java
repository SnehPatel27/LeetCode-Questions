class DisjointSet{

    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){

        if(node == parent.get(node)){
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent; // Or could return parent.get(node);
    }

    public void unionBySize(int node1, int node2){
        int parentOfNode1 = findParent(node1);
        int parentOfNode2 = findParent(node2);

        if(parentOfNode1 == parentOfNode2){
            return;
        }

        if(size.get(parentOfNode2) > size.get(parentOfNode1)){
            parent.set(parentOfNode1, parentOfNode2);
            size.set(parentOfNode2, size.get(parentOfNode2) + size.get(parentOfNode1));
        } else {
            parent.set(parentOfNode2, parentOfNode1);
            size.set(parentOfNode1, size.get(parentOfNode1) + size.get(parentOfNode2));
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