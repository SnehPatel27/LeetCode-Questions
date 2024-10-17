class Solution {
    public String destCity(List<List<String>> paths) {
        
        for(int i = 0; i < paths.size(); i++){
            String candidate = paths.get(i).get(1);
            System.out.println("The candidate is " +candidate);
            Boolean flag = true;

            for(int j = 0; j < paths.size(); j++){
                if(candidate.equals(paths.get(j).get(0))){
                    flag = false;
                }
            }
            if(flag){
                return candidate;
            }
        }

        return "";
    }
}