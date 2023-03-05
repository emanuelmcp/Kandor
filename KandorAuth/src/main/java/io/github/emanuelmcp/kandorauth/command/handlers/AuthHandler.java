package io.github.emanuelmcp.kandorauth.command.handlers;

import com.google.inject.Inject;
import io.github.emanuelmcp.kandorauth.entity.Account;
import io.github.emanuelmcp.kandorauth.repository.AccountRepositoryImpl;
import io.reactivex.rxjava3.disposables.Disposable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;

@SuppressWarnings("unused")
public class AuthHandler {
    private final AccountRepositoryImpl accountRepositoryImpl;
    @Inject
    public AuthHandler(AccountRepositoryImpl accountRepositoryImpl) {
        this.accountRepositoryImpl = accountRepositoryImpl;
    }
    public void login(@NotNull Player player){
        final String UUID = player.getUniqueId().toString();
        Disposable subscription = accountRepositoryImpl.findByUuid(UUID)
                .subscribe(
                account -> {
                    player.sendMessage("Hola bienvenido al servidor");
                },
                error -> {
                    Bukkit.getLogger().warning("Se ha producido un error");
                    player.kick();
                },
                () -> {
                    player.sendMessage("Debes registrarte");
                }
                );
    }
    public void registerPlayer(@NotNull Player player, String password){
        final String UUID = player.getUniqueId().toString();
        Disposable subscription = accountRepositoryImpl.findByUuid(UUID).subscribe(
                account -> {
                    player.sendMessage("Ya estás registrado");
                },
                error -> {
                    Bukkit.getLogger().warning("Se ha producido un error");
                    player.kick();
                },
                () -> {
                    Account account = Account
                            .builder()
                            .uuid(UUID)
                            .nick(player.getName())
                            .password(password)
                            .lastLogin(new Timestamp(System.currentTimeMillis()))
                            .banned(false)
                            .logged(true)
                            .build();
                    accountRepositoryImpl.save(account);
                    player.sendMessage("Te has registrado correctamente");
                }
        );
    }
}
