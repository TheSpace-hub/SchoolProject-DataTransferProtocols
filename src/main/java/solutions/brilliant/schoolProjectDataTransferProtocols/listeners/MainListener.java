package solutions.brilliant.schoolProjectDataTransferProtocols.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.ConnectionTask;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataOut;

import java.util.logging.Level;

public class MainListener implements Listener {

    private final ConnectionTask task;

    public MainListener(ConnectionTask task) {
        this.task = task;
    }

    @EventHandler
    public void onPlayerDamageItemEvent(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player))
            return;
        DataOut out = new DataOut();
        out.level = (int) Math.ceil(player.getHealth()) / 2;
        task.setDataOut(out);
    }

    @EventHandler
    public void onRegainHealthEvent(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof Player player))
            return;
        DataOut out = new DataOut();
        out.level = (int) Math.ceil(player.getHealth()) / 2;
        task.setDataOut(out);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        DataOut out = new DataOut();
        out.level = 0;
        task.setDataOut(out);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        DataOut out = new DataOut();
        out.level = (int) Math.ceil(event.getPlayer().getHealth()) / 2;
        task.setDataOut(out);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        DataOut out = new DataOut();
        out.level = (int) Math.ceil(event.getPlayer().getHealth()) / 2;
        task.setDataOut(out);
    }

}
