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
        Connector connector = new Connector(25570, "127.0.0.1");

        ConnectionTask task = new ConnectionTask(connector);
        Bukkit.getScheduler().runTaskTimer(this, task, 20L, 20L);

        getCommand("sp").setExecutor(new SP(task));
        getCommand("sp").setTabCompleter(new SP(task));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
