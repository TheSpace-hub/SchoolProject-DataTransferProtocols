package solutions.brilliant.schoolProjectDataTransferProtocols.connector;

import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Nullable;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataIn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

public class Connector {

    private final int port;
    private final String available;

    private BufferedReader reader;
    private BufferedWriter writer;

    public Connector(int port, String available) {
        this.port = port;
        this.available = available;
    }

    public void openConnection() {
        ServerSocket serverSocket = getServerSocket(port);
        if (serverSocket == null) return;

        Bukkit.getLogger().log(Level.INFO, "Ожидание подключения...");
        Socket socket = acceptConnection(serverSocket);
        Bukkit.getLogger().log(Level.INFO, "Подключение установленно");
        if (socket == null) return;

        reader = getBufferedReader(socket);
        writer = getBufferedWriter(socket);

        if (reader == null || writer == null) {
            reader = null;
            writer = null;
            return;
        }

        Bukkit.getLogger().log(Level.FINEST, "Соединение успешно установленно");
    }

    public DataIn getData() {
        return new GsonBuilder().create().fromJson(getReaderData(), DataIn.class);
    }

    private @Nullable ServerSocket getServerSocket(int port) {
        try {
            return new ServerSocket(port);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Ошибка при создании сокета сервера (вероятно, порт занят)");
        }
        return null;
    }

    private @Nullable String getReaderData() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private static Socket acceptConnection(ServerSocket serverSocket) {
        try {
            return serverSocket.accept();
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Ошибка при принятии соединения");
        }
        return null;
    }

    private static BufferedReader getBufferedReader(Socket socket) {
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Ошибка при создании buffer reader");
        }
        return null;
    }

    private static BufferedWriter getBufferedWriter(Socket socket) {
        try {
            return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Ошибка при создании buffer writer");
        }
        return null;
    }

    public int getPort() {
        return port;
    }

    public String getAvailable() {
        return available;
    }

}
