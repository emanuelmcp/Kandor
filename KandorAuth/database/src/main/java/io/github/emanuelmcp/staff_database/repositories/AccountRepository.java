package io.github.emanuelmcp.staff_database.repositories;
import io.github.emanuelmcp.api.database.repository.CrudRepository;
import io.github.emanuelmcp.staff_database.models.Account;
import org.bukkit.entity.Player;

public interface AccountRepository extends CrudRepository<Account, String> {

}
