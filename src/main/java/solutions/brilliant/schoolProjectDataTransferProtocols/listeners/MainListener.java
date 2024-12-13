package solutions.brilliant.schoolProjectDataTransferProtocols.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.ConnectionTask;
import solutions.brilliant.schoolProjectDataTransferProtocols.data.DataOut;

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
        out.level = getNormalPlayerHealth(player);
        task.setDataOut(out);
    }

    @EventHandler
    public void onRegainHealthEvent(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof Player player))
            return;
        DataOut out = new DataOut();
        out.level = getNormalPlayerHealth(player);
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
        out.level = getNormalPlayerHealthScale(event.getPlayer());
        task.setDataOut(out);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        DataOut out = new DataOut();
        out.level = getNormalPlayerHealthScale(event.getPlayer());
        task.setDataOut(out);
    }

    private int getNormalPlayerHealth(Player player) {
        return (int) Math.ceil(Math.ceil(player.getHealth()) / 2);
    }

    private int getNormalPlayerHealthScale(Player player) {
        return (int) Math.ceil(Math.ceil(player.getHealthScale()) / 2);
    }

}
