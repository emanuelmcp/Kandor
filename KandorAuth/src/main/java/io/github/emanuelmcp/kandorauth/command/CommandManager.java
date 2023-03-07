package io.github.emanuelmcp.kandorauth.command;

import io.github.emanuelmcp.kandorauth.api.SubCommand;
import io.github.emanuelmcp.kandorauth.command.subcommands.GroupCreateCmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {
    private final ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager() {
        subCommands.add(new GroupCreateCmd());
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando debe ser usado por un jugador");
            return true;
        }
        return false;
    }
}
