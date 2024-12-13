package solutions.brilliant.schoolProjectDataTransferProtocols;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import solutions.brilliant.schoolProjectDataTransferProtocols.commands.SP;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.ConnectionTask;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.Connector;

public final class SchoolProjectDataTransferProtocols extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("sp").setExecutor(new SP());
        Connector connector = new Connector(25570, "127.0.0.1");
        connector.openConnection();

        ConnectionTask task = new ConnectionTask(connector);
        Bukkit.getScheduler().runTaskTimer(this, task, 20L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
