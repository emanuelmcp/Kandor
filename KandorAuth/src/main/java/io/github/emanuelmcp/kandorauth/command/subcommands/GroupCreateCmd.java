package io.github.emanuelmcp.kandorauth.command.subcommands;

import io.github.emanuelmcp.kandorauth.api.SubCommand;
import org.bukkit.entity.Player;

public class GroupCreateCmd implements SubCommand {
    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return "Comando para crear grupo";
    }

    @Override
    public String getSyntax() {
        return "/group create <nombre del grupo";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length != 2) {
            player.sendMessage("Este comando no se utiliza así");
        }
    }
}
