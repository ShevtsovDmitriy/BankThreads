public class Account {
    private static Account ourInstance = new Account();

    public static Account getInstance() {
        return ourInstance;
    }

    private Account() {
        amount = 100;
    }

    private int amount;

    public int getAmount() {
        return amount;
    }

    public synchronized void add(int summ){
        amount += summ;
    }

    public synchronized void get(int summ){
        if (amount >= summ)
            amount -= summ;
    }

}
