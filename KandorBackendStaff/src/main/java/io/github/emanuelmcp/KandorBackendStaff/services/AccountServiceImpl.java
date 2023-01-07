package io.github.emanuelmcp.KandorBackendStaff.services;

import io.github.emanuelmcp.KandorBackendStaff.api.services.AccountService;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;
import io.github.emanuelmcp.KandorBackendStaff.database.repositories.AccountRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepositoryImpl accountRepository;

    public AccountServiceImpl(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String save(Account model) {
        return accountRepository.save(model);
    }

    @Override
    public void update(Account model) {
        model.update(model);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Account> findAll(int size, int page, String queryable) {
        return accountRepository.findAll(0, 10, queryable);
    }

    @Override
    public Account findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }
}
