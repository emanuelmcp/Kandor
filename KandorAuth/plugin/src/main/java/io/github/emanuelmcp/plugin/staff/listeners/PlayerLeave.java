package io.github.emanuelmcp.plugin.staff.listeners;

import com.google.inject.Inject;
import io.github.emanuelmcp.staff_database.models.Account;
import io.github.emanuelmcp.staff_database.repositories.AccountRepositoryImpl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    private final AccountRepositoryImpl repository;
    private final FileConfiguration configuration;
    @Inject
    public PlayerLeave(AccountRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (!repository.exists(player.getUniqueId().toString())) return;
        Account account = repository.findById(player.getUniqueId().toString());
        account.setLogged(false);
        repository.update(account);
    }
}
