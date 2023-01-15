package io.github.emanuelmcp.KandorBackendStaff.database;

import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>, PagingAndSortingRepository<Account, String> {
}
