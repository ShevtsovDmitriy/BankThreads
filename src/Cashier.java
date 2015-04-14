import java.util.ArrayDeque;
import java.util.LinkedList;

public class Cashier extends Thread {

    private  volatile LinkedList<Client> queue ;

    public void setQueue(LinkedList<Client> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        go();
    }

    private void go(){
        while (true){
            Client cl = queue.poll();
            if (cl != null){
                switch (cl.getOperationType()){
                    case ADD:{
                        //System.out.print("operation: " + cl.getOperationType() + " summ: " + cl.getTargetSumm() + "\n");
                        Account.getInstance().add(cl.getTargetSumm());
                        try {
                            Thread.sleep(cl.getOperationTime());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case GET:{
                        //System.out.print("operation: " + cl.getOperationType() + " summ: " + cl.getTargetSumm() + "\n");
                        Account.getInstance().get(cl.getTargetSumm());
                        try {
                            Thread.sleep(cl.getOperationTime());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case CHECK:{
                        //System.out.print("operation: " + cl.getOperationType() + "\n");
                        Account.getInstance().getAmount();
                        try {
                            Thread.sleep(cl.getOperationTime());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
       }

    }


}
