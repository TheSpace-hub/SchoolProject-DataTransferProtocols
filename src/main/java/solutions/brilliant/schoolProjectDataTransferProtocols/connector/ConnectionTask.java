package solutions.brilliant.schoolProjectDataTransferProtocols.connector;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataIn;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataOut;

import java.util.logging.Level;

public class ConnectionTask implements Runnable {

    private final Connector connector;
    private DataIn dataIn = new DataIn();
    private DataOut dataOut = new DataOut();

    public ConnectionTask(Connector connector) {
        this.connector = connector;
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

    public DataIn getData() {
        return dataIn;
    }

    @Override
    public void run() {
        if (!connector.isConnected()) return;
        dataIn = connector.getData();
        connector.sendData(dataOut);
    }

}
