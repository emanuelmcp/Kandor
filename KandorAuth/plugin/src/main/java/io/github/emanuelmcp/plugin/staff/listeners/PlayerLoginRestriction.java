package io.github.emanuelmcp.plugin.staff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerLoginRestriction implements Listener {
    @EventHandler
    void freeze(PlayerMoveEvent event){
        if (PlayerJoin.RESTRICTED_PLAYERS.contains(event.getPlayer().getUniqueId())) event.setCancelled(true);
    }
}
