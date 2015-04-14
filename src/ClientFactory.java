import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class ClientFactory extends Thread {

    private ArrayList<LinkedList<Client>> queues;

    public void setQueues(ArrayList<LinkedList<Client>> queues) {
        this.queues = queues;
    }

    @Override
    public void run() {
        addClients();
    }

    private void addClients(){
        while(true){
            Client cl = generateClient();
            if (cl != null){
                int temp=fountMinQueue();
                queues.get(temp).add(cl);
                //System.out.println("client added " + temp);
            }
            try {
                Thread.sleep((new Random()).nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int fountMinQueue(){
        int min = 0;
        for (int i = 0; i < queues.size(); i++) {
            if (queues.get(i).size() < queues.get(min).size()){
                min = i;
            }
        }
        return min;

    }

    private Client generateClient(){
        Random rnd = new Random();
        int type = rnd.nextInt(5);
        switch (type){
            case 0: return new Client(Client.operationType.ADD, rnd.nextInt(1000), 1000);
            case 1: return new Client(Client.operationType.GET, rnd.nextInt(1000), 2000);
            case 2: return new Client(Client.operationType.CHECK, 500);
            default: return null;
        }
    }

}
