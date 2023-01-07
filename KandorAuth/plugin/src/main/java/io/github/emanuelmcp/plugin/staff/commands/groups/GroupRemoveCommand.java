package io.github.emanuelmcp.plugin.staff.commands.groups;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.commands.SubCommand;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.staff_database.repositories.GroupRepositoryImpl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class GroupRemoveCommand implements SubCommand {
    private final GroupRepositoryImpl repository;
    private final FileConfiguration configuration;
    @Inject
    public GroupRemoveCommand(GroupRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "Remove a group";
    }

    @Override
    public String getSyntax() {
        return "/group remove <group name>";
    }

    @Override
    public void perform(Player player, String[] args) {

        final String parentPath = "messages.commands.";
        final String commandPath = parentPath + "group_remove.";
        String message;

        //Si la cantidad de argumentos no es valida
        if (args.length != 2){
            message = configuration.getString(parentPath +"command_args_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            System.out.println(message);
            return;
        }
        //Si no existe el grupo
        if (!repository.exists(args[1])) {
            message = configuration.getString(commandPath +"group_not_exists");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return;
        }

        repository.remove(args[1]);

        message = configuration.getString(commandPath + "successful");
        player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));

    }
}
