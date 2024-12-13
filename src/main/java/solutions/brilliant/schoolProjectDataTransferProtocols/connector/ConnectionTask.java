package solutions.brilliant.schoolProjectDataTransferProtocols.connector;

import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataIn;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataOut;

public class ConnectionTask implements Runnable {

    private final Connector connector;
    private DataIn dataIn;
    private DataOut dataOut;

    public ConnectionTask(Connector connector) {
        this.connector = connector;
    }

    public void setDataOut(DataOut data) {
        dataOut = data;
    }

    public DataIn getData() {
        return dataIn;
    }

    @Override
    public void run() {
        dataIn = connector.getData();
        connector.sendData(dataOut);
    }

}
