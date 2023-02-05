package io.github.emanuelmcp.minecraftcore.listeners.login;

import com.google.inject.Inject;
import io.github.emanuelmcp.minecraftcore.models.Account;
import io.github.emanuelmcp.minecraftcore.repository.AccountRepository;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Optional;

public class PlayerJoinEvent implements Listener {
    private final AccountRepository repository;
    @Inject
    public PlayerJoinEvent(AccountRepository repository) {
        this.repository = repository;
    }
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        final String UUID = player.getUniqueId().toString();
        Optional<Account> account = repository.read(UUID);
        if (account.isPresent()) player.sendMessage("Todo bien mirrey");
        else player.sendMessage("Algo salió mal");
    }
}
