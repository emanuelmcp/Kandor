package io.github.emanuelmcp.kandorauth.command;

import com.google.inject.Inject;
import io.github.emanuelmcp.kandorauth.command.handlers.AuthHandler;
import io.github.emanuelmcp.kandorauth.util.PasswordUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
public class RegisterCmd implements CommandExecutor {

    private final AuthHandler authHandler;
    @Inject
    public RegisterCmd(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //Si no lo utiliza un jugador
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando debe ser usado por un jugador");
            return true;
        }
        if (args.length != 2) {
            player.sendMessage("La cantidad de argumentos es inválida");
            return false;
        }
        if (!PasswordUtils.passwordIsValid(args[0])) {
            player.sendMessage("La contraseña no cumple con los criterios de seguridad");
            return true;
        }
        authHandler.registerPlayer(player, args[0]);
        return true;
    }
}
