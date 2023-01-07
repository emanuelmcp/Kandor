package io.github.emanuelmcp.plugin.authentication.commands;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.api.utils.PasswordUtils;
import io.github.emanuelmcp.plugin.staff.listeners.PlayerJoin;
import io.github.emanuelmcp.staff_database.models.Account;
import io.github.emanuelmcp.staff_database.repositories.AccountRepositoryImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.*;
public class LoginCommand implements CommandExecutor, Listener {
    private final AccountRepositoryImpl repository;
    private final FileConfiguration configuration;

    @Inject
    public LoginCommand(AccountRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args) {

        final String parentPath = "messages.commands.";
        final String commandPath = parentPath + "login.";
        String message;
        //Si no lo utiliza un jugador
        if (!(sender instanceof Player player)) {
            message = parentPath + "command_use_error";
            sender.sendMessage(ChatUtils.color(message));
            return true;
        }
        //Si el jugador no existe en la base de datos
        if (!repository.exists(player.getUniqueId().toString())) {
            message = configuration.getString(commandPath +"player_not_exists");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la cantidad de argumentos no es válida
        if (args.length != 1) {
            message = configuration.getString(parentPath +"command_args_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }

        Account account = repository.findById(player.getUniqueId().toString());
        //Si ya está loggeado
        if (account.isLogged()) {
            message = configuration.getString(commandPath + "is_logged");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la contraseña introducida no es la misma
        if (!PasswordUtils.comparePassword(args[0], account.getPassword())) {
            message = configuration.getString(commandPath + "password_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }

        account.setLogged(true);
        repository.update(account);

        PlayerJoin.RESTRICTED_PLAYERS.remove(player.getUniqueId());

        message = configuration.getString(commandPath + "successful");
        player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));

        return true;
    }

}
