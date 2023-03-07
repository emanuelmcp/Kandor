package io.github.emanuelmcp.kandorauth.command.handlers;

import com.google.inject.Inject;
import feign.FeignException;
import io.github.emanuelmcp.kandorauth.entity.Group;
import io.github.emanuelmcp.kandorauth.repository.GroupRepository;
import org.bukkit.Bukkit;

public class GroupHandler {
    private final GroupRepository groupRepository;
    @Inject
    public GroupHandler(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    public void createGroup(String name) {
        Group group = Group.builder().groupName(name).build();
        try {
            this.groupRepository.save(group);
        } catch (FeignException ignore) {
            Bukkit.getLogger().warning("No se puede guardar el grupo");
        }
    }
    public void deleteGroup(String groupName) {
        this.groupRepository.delete(groupName);
    }
/*    public void setPrefixGroup(String groupName, String prefix) {
        Group updatedGroup = Group.builder().prefix(prefix).build();
        groupRepository.update(groupName, updatedGroup)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        group -> Bukkit.getLogger().warning("grupo actualizado"),
                        throwable -> Bukkit.getLogger().warning("algo ha salido mal"),
                        () -> Bukkit.getLogger().warning("NOOOOOOOOOOOO")
                );
    }*/
    public void setPrefixGroup(String groupName, String prefix) {
        Group updatedGroup = Group.builder().prefix(prefix).build();
        groupRepository.update(groupName, updatedGroup)
                .doOnComplete(() -> Bukkit.getLogger().warning("Prefijo actualizado"))
                .doOnError(throwable -> Bukkit.getLogger().warning("No se ha podido actualizar el prefijo"))
                .subscribe();
    }
}
