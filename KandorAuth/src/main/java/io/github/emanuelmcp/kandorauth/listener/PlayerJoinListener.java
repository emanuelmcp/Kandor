package io.github.emanuelmcp.kandorauth.listener;

import com.google.inject.Inject;
import io.github.emanuelmcp.kandorauth.repository.AccountRepositoryImpl;
import io.reactivex.rxjava3.disposables.Disposable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinListener implements Listener {
    //TODO: gestionar mensajes de una forma dinámica
    private final AccountRepositoryImpl accountRepositoryImpl;
    private final JavaPlugin plugin;
    @Inject
    public PlayerJoinListener(AccountRepositoryImpl accountRepositoryImpl, JavaPlugin plugin) {
        this.accountRepositoryImpl = accountRepositoryImpl;
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        //FIXME: cerrar el observable

        Player player = event.getPlayer();
        final String UUID = player.getUniqueId().toString();
        Disposable subscription = accountRepositoryImpl.findByUuid(UUID).subscribe(
                account -> {
                    player.sendMessage("Hola bienvenido al servidor");
                },
                error -> {
                    Bukkit.getLogger().warning("Se ha producido un error");
                    player.kick();
                },
                () -> {
                    player.sendMessage("No estás registrado");
                }
        );
    }
}
