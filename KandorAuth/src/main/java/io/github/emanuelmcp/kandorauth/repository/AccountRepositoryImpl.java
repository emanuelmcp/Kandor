package io.github.emanuelmcp.kandorauth.repository;

import com.google.inject.Inject;
import feign.FeignException;
import io.github.emanuelmcp.kandorauth.api.EndpointFactory;
import io.github.emanuelmcp.kandorauth.api.repository.AccountRepository;
import io.github.emanuelmcp.kandorauth.entity.Account;
import io.github.emanuelmcp.kandorauth.rest.AccountEndpoint;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class AccountRepositoryImpl implements AccountRepository {
    private final FileConfiguration CONFIG;
    private final String BASE_ENDPOINT;
    @Inject
    public AccountRepositoryImpl(@NotNull FileConfiguration CONFIG, String baseEndpoint) {
        this.CONFIG = CONFIG;
        BASE_ENDPOINT = CONFIG.getString("api");
    }
    public Maybe<Account> findByUuid(String uuid){
        return Maybe.fromCallable(() -> {
            AccountEndpoint api = EndpointFactory.create(AccountEndpoint.class, BASE_ENDPOINT);
                    return api.getAccount(uuid);
                })
                .subscribeOn(Schedulers.io())
                .onErrorComplete(FeignException.class::isInstance)
                .cast(Account.class);
    }
    public void save(Account account) {
        AccountEndpoint api = EndpointFactory.create(AccountEndpoint.class, BASE_ENDPOINT);
        api.saveAccount(account);
    }
}
