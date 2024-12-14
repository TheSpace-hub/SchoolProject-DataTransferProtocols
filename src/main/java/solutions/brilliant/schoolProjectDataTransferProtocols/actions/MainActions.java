package solutions.brilliant.schoolProjectDataTransferProtocols.actions;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class MainActions {

    private final Plugin plugin;
    private Player player;

    public MainActions(Plugin plugin) {
        this.plugin = plugin;
    }

    public void k1() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k1").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K1");
    }

    public void k2() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k2").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K2");
    }
    public void k3() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k3").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K3");
    }

    public void k4() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k4").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K4");
    }

    public void k5() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k5").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K5");
    }

    public void k6() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k6").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K6");
    }

    public void k7() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("k7").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: K7");
    }

    public void red_key() {
        ConfigurationSection actions = plugin.getConfig().getConfigurationSection("actions");
        if (actions.getString("red_key").equals("auto"))
            Bukkit.getLogger().log(Level.WARNING, "Action: Red key");
    }


}
