package io.github.emanuelmcp.KandorBackendStaff.api.service;

import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Page<Account> getPage(Pageable pageable);
    Optional<Account> viewById(String uuid);
    void delete(String id);
    Account save(Account account);
    Account update(Account account);
}
