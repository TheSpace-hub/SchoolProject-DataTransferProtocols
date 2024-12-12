package solutions.brilliant.schoolProjectDataTransferProtocols;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import solutions.brilliant.schoolProjectDataTransferProtocols.commands.SP;

public final class SchoolProjectDataTransferProtocols extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("sp").setExecutor(new SP());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
