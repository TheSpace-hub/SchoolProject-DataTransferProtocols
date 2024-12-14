package solutions.brilliant.schoolProjectDataTransferProtocols.connector;

import org.jetbrains.annotations.NotNull;
import solutions.brilliant.schoolProjectDataTransferProtocols.actions.MainActions;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataIn;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataOut;

public class ConnectionTask implements Runnable {

    private final Connector connector;
    private final MainActions actions;

    private DataIn dataIn = new DataIn();
    private DataOut dataOut = new DataOut();

    public ConnectionTask(MainActions actions, Connector connector) {
        this.connector = connector;
        this.actions = actions;

        dataOut.level = 0;

        dataIn.k1 = false;
        dataIn.k2 = false;
        dataIn.k3 = false;
        dataIn.k4 = false;
        dataIn.k5 = false;
        dataIn.k6 = false;
        dataIn.k7 = false;
        dataIn.red_key = false;
    }

    public void Connect() {
        connector.openConnection();
    }

    public void setDataOut(DataOut data) {
        dataOut = data;
    }

    @Override
    public void run() {
        if (!connector.isConnected()) return;
        dataIn = connector.getData();
        connector.sendData(dataOut);
        check(dataIn);
    }

    private void check(@NotNull DataIn data) {
        if (data.k1) actions.k1();
        if (data.k2) actions.k2();
        if (data.k3) actions.k3();
        if (data.k4) actions.k4();
        if (data.k5) actions.k5();
        if (data.k6) actions.k6();
        if (data.k7) actions.k7();
        if (data.red_key) actions.red_key();
    }

}
