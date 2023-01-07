package io.github.emanuelmcp.plugin.staff.listeners;

import com.google.inject.Inject;
import io.github.emanuelmcp.api.utils.ChatUtils;
import io.github.emanuelmcp.staff_database.models.Account;
import io.github.emanuelmcp.staff_database.repositories.AccountRepositoryImpl;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerJoin implements Listener {
    private final AccountRepositoryImpl repository;
    private final FileConfiguration configuration;
    public static final Set<UUID> RESTRICTED_PLAYERS = new HashSet<>();
    @Inject
    public PlayerJoin(AccountRepositoryImpl repository, FileConfiguration configuration) {
        this.repository = repository;
        this.configuration = configuration;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        String titlesPath = "title_messages.";
        String registerPath = titlesPath + "register_message.";
        String loginPath = titlesPath + "login_message.";

        String title;
        String subtitle;

        RESTRICTED_PLAYERS.add(event.getPlayer().getUniqueId());

        Player player = event.getPlayer();
        Account account = repository.findById(player.getUniqueId().toString());

        if (!repository.exists(player.getUniqueId().toString())) {
            title = configuration.getString(registerPath + "title");
            subtitle = configuration.getString(registerPath + "subtitle");
            assert title != null;
            ChatUtils.color(title);
            assert subtitle != null;
            ChatUtils.color(subtitle);
            player.sendTitle(
                    title, subtitle,
                    configuration.getInt(registerPath + "fadeIn"),
                    configuration.getInt(registerPath + "stay"),
                    configuration.getInt(registerPath + "fadeOut")
                    );
            return;
        }

        if (account.isBanned()) {
            player.kickPlayer("ESTAS BANEADO");
            return;
        }

        title = configuration.getString(loginPath + "title");
        subtitle = configuration.getString(loginPath + "subtitle");
        assert title != null;
        ChatUtils.color(title);
        assert subtitle != null;
        ChatUtils.color(subtitle);
        player.sendTitle(
                title, subtitle,
                configuration.getInt(loginPath + "fadeIn"),
                configuration.getInt(loginPath + "stay"),
                configuration.getInt(loginPath + "fadeOut"));
    }
}
