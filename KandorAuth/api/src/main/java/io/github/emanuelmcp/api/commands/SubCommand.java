package io.github.emanuelmcp.api.commands;

import org.bukkit.entity.Player;

public interface SubCommand {
    String getName();
    String getDescription();
    String getSyntax();
    void perform(Player player, String[] args);
}
