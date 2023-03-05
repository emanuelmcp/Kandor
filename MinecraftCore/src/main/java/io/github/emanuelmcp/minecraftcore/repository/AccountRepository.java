
package io.github.emanuelmcp.minecraftcore.repository;

import com.google.inject.Inject;
import feign.FeignException;
import io.github.emanuelmcp.minecraftcore.models.Account;
import io.github.emanuelmcp.minecraftcore.api.rest.endpoints.AccountEndpoint;
import io.github.emanuelmcp.minecraftcore.api.rest.EndpointFactory;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Optional;

@SuppressWarnings("unused")
public class AccountRepository {
    private final FileConfiguration CONFIG;
    private final String BASE_ENDPOINT;
    @Inject
    public AccountRepository(FileConfiguration CONFIG, String baseEndpoint) {
        this.CONFIG = CONFIG;
        BASE_ENDPOINT = CONFIG.getString("api");
    }
    public Account create(Account account){
        AccountEndpoint api = EndpointFactory.create(AccountEndpoint.class, BASE_ENDPOINT);
        return api.saveAccount(account);
    }
    public Optional<Account> read(String uuid){
        Optional<Account> account = Optional.empty();
        try{
            AccountEndpoint api = EndpointFactory.create(AccountEndpoint.class, BASE_ENDPOINT);
            account = Optional.ofNullable(api.getAccount(uuid));
        } catch (FeignException exception) {
            Bukkit.getLogger().warning("New user on server");
        }
        return account;
    }
}