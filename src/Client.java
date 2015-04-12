/**
 * Created by ִלטענטי on 12.04.2015.
 */
public class Client {

    public static enum operationType{GET, ADD, CHECK}

    private operationType operationType;
    private int targetSumm;
    private int operationTime;

    public Client(Client.operationType operationType, int targetSumm, int operationTime) {
        this.operationType = operationType;
        this.targetSumm = targetSumm;
        this.operationTime = operationTime;
    }

    public Client(Client.operationType operationType, int operationTime) {
        this.operationType = operationType;
        this.operationTime = operationTime;
        this.targetSumm = 0;
    }

    public Client.operationType getOperationType() {
        return operationType;
    }

    public int getTargetSumm() {
        return targetSumm;
    }

    public int getOperationTime() {
        return operationTime;
    }
}
