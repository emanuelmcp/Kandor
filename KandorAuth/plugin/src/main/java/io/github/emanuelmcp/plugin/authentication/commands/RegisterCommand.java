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

import java.util.Objects;

public class RegisterCommand implements CommandExecutor, Listener {
    private final AccountRepositoryImpl repository;
    private final FileConfiguration configuration;
    @Inject
    public RegisterCommand(AccountRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {

        final String parentPath = "messages.commands.";
        final String commandPath = parentPath + "register.";

        String message;
        //Si no lo utiliza un jugador
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatUtils.color(parentPath + "command_use_error"));
            return true;
        }
        //Si el jugador ya existe en la base de datos
        if (repository.exists(player.getUniqueId().toString())) {
            message = configuration.getString(commandPath +"is_registered");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la cantidad de argumentos no es válida
        if (args.length != 2) {
            message = configuration.getString(parentPath +"command_args_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            System.out.println(message);
            return true;
        }
        //Si las contraseñas no coinciden
        if (!PasswordUtils.ifSamePasswords(args[0], args[1])) {
            message = configuration.getString(commandPath + "not_same_passwords");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la contraseña no cumple los criterios de seguridad
        if (!PasswordUtils.passwordIsValid(args[0])) {
            message = configuration.getString(commandPath + "not_secure_password");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }

        Account account = Account.builder()
                .uuid(player.getUniqueId().toString())
                .nick(player.getDisplayName())
                .password(PasswordUtils.encryptPassword(args[0]))
                .banned(false)
                .logged(true)
                .build();

        repository.save(account);

        PlayerJoin.RESTRICTED_PLAYERS.remove(player.getUniqueId());

        message = configuration.getString(commandPath + "successful");
        player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));

        return true;
    }
}

