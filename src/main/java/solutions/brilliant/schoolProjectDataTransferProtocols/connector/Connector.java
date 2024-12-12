package solutions.brilliant.schoolProjectDataTransferProtocols.connector;

public class Connector {

    private final int port;
    private final String available;

    public Connector(int port, String available) {
        this.port = port;
        this.available = available;
    }

    public int getPort() {
        return port;
    }

    public String getAvailable() {
        return available;
    }

}
