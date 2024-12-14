package solutions.brilliant.schoolProjectDataTransferProtocols;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import solutions.brilliant.schoolProjectDataTransferProtocols.actions.MainActions;
import solutions.brilliant.schoolProjectDataTransferProtocols.commands.SP;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.ConnectionTask;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.Connector;
import solutions.brilliant.schoolProjectDataTransferProtocols.listeners.MainListener;

public final class SchoolProjectDataTransferProtocols extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Connector connector = new Connector(25570, "127.0.0.1");
        MainActions actions = new MainActions(this);
        ConnectionTask task = new ConnectionTask(actions, connector);

        Bukkit.getScheduler().runTaskTimer(this, task, 1L, 1L);

        getCommand("sp").setExecutor(new SP(task));
        getCommand("sp").setTabCompleter(new SP(task));

        getServer().getPluginManager().registerEvents(new MainListener(task), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
