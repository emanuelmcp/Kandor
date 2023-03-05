package io.github.emanuelmcp.kandorauth.command;

import com.google.inject.Inject;
import io.github.emanuelmcp.kandorauth.command.handlers.AuthHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LoginCmd implements CommandExecutor {
    //TODO: gestionar mensajes de una forma dinámica
    //FIXME: cerrar observable
    private final AuthHandler authHandler;
    @Inject
    public LoginCmd(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args) {
        //Si no lo utiliza un jugador
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando debe ser usado por un jugador");
            return true;
        }
        authHandler.login(player);
        return true;
    }
}
