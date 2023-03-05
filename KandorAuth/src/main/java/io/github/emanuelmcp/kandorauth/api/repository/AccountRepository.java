package io.github.emanuelmcp.kandorauth.api.repository;

import io.github.emanuelmcp.kandorauth.entity.Account;
import io.reactivex.rxjava3.core.Maybe;

public interface AccountRepository {
    Maybe<Account> findByUuid(String uuid);
    void save(Account account);
}
