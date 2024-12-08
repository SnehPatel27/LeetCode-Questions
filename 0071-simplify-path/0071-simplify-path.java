class Solution {
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<>();

        String[] temp = path.split("/");
        int i = 0;

        while(i < temp.length){

            if(temp[i].equals("..")){
                if(!result.isEmpty()){
                    result.remove(result.size() - 1);
                }
            }
            else if(!temp[i].isEmpty() && !temp[i].equals(".")){
                result.add(temp[i]);
            }

            i++;

        }

        StringBuilder res = new StringBuilder();
        
        for(int j = 0; j < result.size(); j++){
            res.append("/").append(result.get(j));
        }

        return res.isEmpty()? "/": res.toString();
    }
}