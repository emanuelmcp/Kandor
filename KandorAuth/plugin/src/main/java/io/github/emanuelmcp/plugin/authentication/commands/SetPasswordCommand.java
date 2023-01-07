package io.github.emanuelmcp.plugin.authentication.commands;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.api.utils.PasswordUtils;
import io.github.emanuelmcp.staff_database.models.Account;
import io.github.emanuelmcp.staff_database.repositories.AccountRepositoryImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetPasswordCommand implements CommandExecutor {
    private final AccountRepositoryImpl repository;
    private final FileConfiguration configuration;
    @Inject
    public SetPasswordCommand(AccountRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args)
    {
        final String parentPath = "messages.commands.";
        final String commandPath = parentPath + "setpassword.";
        String message;
        //Si no lo utliza un jugador
        if (!(sender instanceof Player player)) {
            message = parentPath + "command_use_error";
            sender.sendMessage(ChatUtils.color(message));
            return true;
        }
        //Si no está en la base de datos
        if (!repository.exists(player.getUniqueId().toString())) {
            message = configuration.getString(commandPath +"player_not_exists");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la cantidad de argumentos no es válida
        if (args.length != 3) {
            message = configuration.getString(parentPath +"command_args_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }

        Account account = repository.findById(player.getUniqueId().toString());
        //Si no está loggeado
        if (!account.isLogged()) {
            message = configuration.getString(commandPath + "not_logged");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la contraseña antigua no es válida
        if (!PasswordUtils.comparePassword(args[0], account.getPassword())) {
            message = configuration.getString(commandPath + "password_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la nueva contraseña no coincide con la confirmación de contraseña
        if (!PasswordUtils.ifSamePasswords(args[1], args[2])) {
            message = configuration.getString(commandPath + "not_same_passwords");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }

        account.setPassword(PasswordUtils.encryptPassword(args[1]));
        repository.update(account);

        message = configuration.getString(commandPath + "successful");
        player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));

        return true;
    }
}
