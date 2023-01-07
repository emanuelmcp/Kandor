package io.github.emanuelmcp.KandorBackendStaff.api.services;

import io.github.emanuelmcp.KandorBackendStaff.api.repository.CrudRepository;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;

public interface AccountService extends CrudRepository<Account, String> {
}
