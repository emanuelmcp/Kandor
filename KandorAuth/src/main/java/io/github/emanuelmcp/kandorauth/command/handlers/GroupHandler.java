package io.github.emanuelmcp.kandorauth.command.handlers;

import com.google.inject.Inject;
import feign.FeignException;
import io.github.emanuelmcp.kandorauth.dto.UpdateGroupDto;
import io.github.emanuelmcp.kandorauth.entity.Group;
import io.github.emanuelmcp.kandorauth.repository.GroupRepository;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.bukkit.Bukkit;

public class GroupHandler {
    private final GroupRepository groupRepository;
    @Inject
    public GroupHandler(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    public void save(String name) {
        Group group = Group.builder().groupName(name).build();
        try {
            this.groupRepository.save(group);
        } catch (FeignException ignore) {
            Bukkit.getLogger().warning("No se puede guardar el grupo");
        }
    }
    public void delete(String groupName) {
        this.groupRepository.delete(groupName);
    }
    public void update(String prefix, String groupName) {
        this.groupRepository.update(groupName, new UpdateGroupDto(prefix, null, null))
                .subscribeOn(Schedulers.io())
                .subscribe(
                        group -> {
                            Bukkit.getLogger().info(String.format("Se ha actualizado el prefijo del grupo %s", groupName));
                        },
                        error -> {
                            Bukkit.getLogger().warning(String.format("Se ha producido un error al actualizar el prefijo del grupo %s", groupName));
                        }
                );
    }
}
