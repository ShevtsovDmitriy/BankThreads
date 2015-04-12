import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ִלטענטי on 12.04.2015.
 */
public class ClientFactory extends Thread {

    private ArrayList<ArrayDeque<Client>> queues;

    public void setQueues(ArrayList<ArrayDeque<Client>> queues) {
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
                queues.get(fountMinQueue()).add(cl);
                //System.out.print("client added\n");
            }
            try {
                Thread.sleep(30);
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
            case 0: return new Client(Client.operationType.ADD, rnd.nextInt(1000), 100);
            case 1: return new Client(Client.operationType.GET, rnd.nextInt(1000), 200);
            case 2: return new Client(Client.operationType.CHECK, 50);
            default: return null;
        }
    }

}
