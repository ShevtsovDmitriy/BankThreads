import java.util.ArrayDeque;
import java.util.ArrayList;

public class Bank {

    private Cashier[] cashiers;
    private ArrayList<ArrayDeque<Client>> queues;
    private ClientFactory clientFactory;

    public Bank(int cashiersCount) {
        cashiers = new Cashier[cashiersCount];
        queues = new ArrayList<ArrayDeque<Client>>();
    }

    public void go(){
        for (int i = 0; i < cashiers.length; i++) {
            queues.add(new ArrayDeque<Client>());
        }
        for (int i = 0; i < cashiers.length ; i++) {
            cashiers[i]  = new Cashier();
            cashiers[i].setQueue(queues.get(i));
        }
        for (Cashier cashier : cashiers) {
            cashier.start();
        }
        clientFactory = new ClientFactory();
        clientFactory.setQueues(queues);
        clientFactory.start();

        printStatus();



    }

    private void printStatus(){
        while(true){
            for (int i = 0; i < queues.size(); i++) {
                System.out.print("Cashier "+ i + " queue:" + queues.get(i).size() + "\n");
            }
            System.out.print("Amount: " + Account.getInstance().getAmount() + "\n");
            System.out.print("-----------------------------------\n-----------------------------------\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
