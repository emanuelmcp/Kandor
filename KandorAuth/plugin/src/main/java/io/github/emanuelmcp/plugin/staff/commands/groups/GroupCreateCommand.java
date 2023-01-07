package io.github.emanuelmcp.plugin.staff.commands.groups;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.commands.SubCommand;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.staff_database.models.Group;
import io.github.emanuelmcp.staff_database.repositories.GroupRepositoryImpl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class GroupCreateCommand implements SubCommand {
    private final GroupRepositoryImpl repository;
    private final FileConfiguration configuration;
    @Inject
    public GroupCreateCommand(GroupRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return "Create a group";
    }

    @Override
    public String getSyntax() {
        return "/group create <group name>";
    }

    @Override
    public void perform(Player player, String[] args) {

        final String parentPath = "messages.commands.";
        final String commandPath = parentPath + "group_add.";
        String message;

        //Si la cantidad de argumentos no es valida
        if (args.length != 2){
            message = configuration.getString(parentPath +"command_args_error");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            System.out.println(message);
            return;
        }
        //Si ya existe el grupo
        if (repository.exists(args[1])) {
            message = configuration.getString(commandPath +"group_exists");
            player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));
            return;
        }

        Group group = Group.builder().groupName(args[1]).build();
        repository.save(group);

        message = configuration.getString(commandPath + "successful");
        player.sendMessage(Objects.requireNonNull(ChatUtils.color(message)));

    }
}
