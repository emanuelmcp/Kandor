package io.github.emanuelmcp.kandorauth.command;

import com.google.inject.Inject;
import io.github.emanuelmcp.kandorauth.command.handlers.GroupHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GroupCmd implements CommandExecutor {
    private final GroupHandler groupHandler;
    @Inject
    public GroupCmd(GroupHandler groupHandler) {
        this.groupHandler = groupHandler;
    }
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args)
    {
        String subcommand = args[0];
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando debe ser usado por un jugador");
            return true;
        }
        switch (subcommand) {
            case "create" -> {
                if (args.length != 2) {
                    player.sendMessage("Este comando no se utiliza así");
                    return true;
                }
                groupHandler.save(args[1]);
                player.sendMessage("Grupo creado");
            }
            case "delete" -> {
                if (args.length != 2) {
                    player.sendMessage("Este comando no se utiliza así");
                    return true;
                }
                groupHandler.delete(args[1]);
                player.sendMessage("Grupo borrado");
            }
            case "add" -> {
                player.sendMessage("Añadir permiso al grupo");
            }
            case "remove" -> {
                player.sendMessage("Eliminar permiso del grupo");
            }
            case "addplayer" -> {
                player.sendMessage("Añadir jugador al grupo");
            }
            case "removeplayer" -> {
                player.sendMessage("Borrar jugador de un grupo");
            }
            case "setprefix" -> {
                if (args.length != 3) {
                    player.sendMessage("Este comando no se utiliza así");
                    return true;
                }
                groupHandler.update(args[1], args[2]);
                player.sendMessage("Has establecido correctamente el prefijo");
            }
            default -> {
                player.sendMessage("Esto es la ayuda del comando /group");
            }
        }
        return true;
    }
}
