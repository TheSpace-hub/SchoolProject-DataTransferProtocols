package solutions.brilliant.schoolProjectDataTransferProtocols.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import solutions.brilliant.schoolProjectDataTransferProtocols.connector.ConnectionTask;

import java.util.ArrayList;
import java.util.List;

public class SP implements CommandExecutor, TabCompleter {

    private final ConnectionTask task;

    public SP(ConnectionTask task) {
        this.task = task;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (!player.hasPermission("sp.admin.start")) {
                player.sendMessage(Component.textOfChildren(
                        Component.text("ШКОЛЬНЫЙ ПРОЕКТ | ОШИБКА | У Вас недостаточно прав для этого")
                                .color(TextColor.color(0xff0000))
                ));
                return false;
            }
            player.sendMessage(Component.textOfChildren(
                    Component.text("ШКОЛЬНЫЙ ПРОЕКТ | Команда успешно выполнена")
                            .color(TextColor.color(0x00ff00))
            ));
        }

        if (strings.length == 1)
            if (strings[0].equals("connect"))
                task.Connect();

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> variants = new ArrayList<>(List.of("connect"));
        if (commandSender instanceof Player player) {
            if (!player.hasPermission("sp.admin.connect"))
                variants.remove("connect");
        }
        return variants;
    }
}
