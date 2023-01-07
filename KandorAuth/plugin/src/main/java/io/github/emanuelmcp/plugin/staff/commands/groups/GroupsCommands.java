package io.github.emanuelmcp.plugin.staff.commands.groups;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.commands.SubCommand;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.staff_database.repositories.AccountRepositoryImpl;
import io.github.emanuelmcp.staff_database.repositories.GroupRepositoryImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GroupsCommands implements CommandExecutor {

    private final List<SubCommand> subCommands = new ArrayList<>();

    @Inject
    public GroupsCommands(
            GroupRepositoryImpl groupRepository,
            AccountRepositoryImpl accountRepository,
            FileConfiguration configuration
    ) {
        subCommands.add(new GroupCreateCommand(groupRepository, configuration));
        subCommands.add(new GroupRemoveCommand(groupRepository, configuration));
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final String parentPath = "messages.commands.";
        //Si no lo utiliza un jugador
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatUtils.color(parentPath + "command_use_error"));
            return true;
        }
        //Si la cantidad de parametros no es válida
        if (!(args.length > 0)){
            sender.sendMessage(ChatUtils.color(parentPath + "command_use_error"));
            return true;
        }
        //Se ejecuta cuando los argumentos coinciden
        for (int i = 0; i <getSubcommands().size(); i++){
            if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                getSubcommands().get(i).perform(player, args);
            }
        }
        return true;
    }
    public List<SubCommand> getSubcommands(){
        return this.subCommands;
    }
}
