class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();

        for(String transaction: transactions){
            Transaction tran = new Transaction(transaction);

            if(map.containsKey(tran.name))
                map.get(tran.name).add(tran);
            else{
                List<Transaction> list = new ArrayList<>();
                list.add(tran);
                map.put(tran.name, list);
            }
        }

        for(String transaction: transactions){
            Transaction tran = new Transaction(transaction);

            if(!isValid(map.get(tran.name), tran))
                result.add(transaction);
        }

        return result;
    }

    public boolean isValid(List<Transaction> transactions, Transaction transaction){

        if(transactions.size() <= 1 && transaction.amount > 1000)
            return false;
        
        for(Transaction tran: transactions){
            if(transaction.invalidTransaction(tran.city, tran.time))
                return false;
        }


        return true;
    }
}

class Transaction{
    String name; 
    int time;
    int amount;
    String city;

    Transaction(String transaction){
        String[] t = transaction.split(",");
        this.name = t[0];
        this.time = Integer.parseInt(t[1]);
        this.amount = Integer.parseInt(t[2]);
        this.city = t[3];
    }

    public boolean invalidTransaction(String city, int time){
        if(invalidAmount() || differentCity(city, time))
            return true;
        
        return false;
    }

    public boolean invalidAmount(){
        if(this.amount > 1000)
            return true;
        return false;
    }       

    public boolean differentCity(String city, int time){
        if(!this.city.equals(city)){
            if(Math.abs(this.time - time) <= 60){
                return true;
            }
        }

        return false;
    }
}