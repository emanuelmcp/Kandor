package io.github.emanuelmcp.plugin.authentication.commands;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.staff_database.repositories.AccountRepositoryImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class UnregisterCommand implements CommandExecutor {
    private final AccountRepositoryImpl repository;
    private final FileConfiguration configuration;
    @Inject
    public UnregisterCommand(AccountRepositoryImpl repository, FileConfiguration configuration) {
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
        final String commandPath = parentPath + "unregister.";

        String message;

        //Si no lo utiliza un jugador
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatUtils.color(parentPath + "command_use_error"));
            return true;
        }
        //Si el jugador ya existe en la base de datos
        if (!repository.exists(player.getUniqueId().toString())) {
            message = configuration.getString(commandPath +"is_not_registered");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }
        //Si la cantidad de argumentos no es válida
        if (args.length != 0) {
            message = configuration.getString(parentPath +"command_args_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return true;
        }

        repository.remove(player.getUniqueId().toString());
        message = configuration.getString(commandPath + "successful");

        player.kickPlayer(message);

        return true;
    }
}
