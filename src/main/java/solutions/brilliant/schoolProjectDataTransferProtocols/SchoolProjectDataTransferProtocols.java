package solutions.brilliant.schoolProjectDataTransferProtocols;

import org.bukkit.plugin.java.JavaPlugin;

public final class SchoolProjectDataTransferProtocols extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
