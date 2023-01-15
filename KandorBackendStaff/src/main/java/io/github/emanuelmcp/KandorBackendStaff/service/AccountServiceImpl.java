package io.github.emanuelmcp.KandorBackendStaff.service;

import io.github.emanuelmcp.KandorBackendStaff.api.AccountService;
import io.github.emanuelmcp.KandorBackendStaff.database.AccountRepository;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Account> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Account> viewById(String uuid) {
        return repository.findById(uuid);
    }

    @Override
    public List<Account> viewAllAccounts() {
        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Account save(Account account) {
        account.setNew(true);
        return repository.save(account);
    }

    @Override
    public Account update(Account account) {
        account.setUuid(account.getUuid());
        return repository.save(account);
    }
}
