package io.github.emanuelmcp.kandorauth.repository;

import com.google.inject.Inject;
import feign.FeignException;
import io.github.emanuelmcp.kandorauth.api.EndpointFactory;
import io.github.emanuelmcp.kandorauth.entity.Group;
import io.github.emanuelmcp.kandorauth.rest.GroupEndpoint;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class GroupRepository {
    private final FileConfiguration CONFIG;
    private final String BASE_ENDPOINT;
    @Inject
    public GroupRepository(@NotNull FileConfiguration CONFIG, String baseEndpoint) {
        this.CONFIG = CONFIG;
        BASE_ENDPOINT = CONFIG.getString("api");
    }
    public Maybe<Group> findById(String groupName){
        return Maybe.fromCallable(() -> {
                    GroupEndpoint api = EndpointFactory.create(GroupEndpoint.class, BASE_ENDPOINT);
                    return api.getGroup(groupName);
                })
                .subscribeOn(Schedulers.io())
                .onErrorComplete(FeignException.class::isInstance)
                .cast(Group.class);
    }
    public void save(Group group) {
        GroupEndpoint api = EndpointFactory.create(GroupEndpoint.class, BASE_ENDPOINT);
        api.save(group);
    }
    public void delete(String groupName) {
        GroupEndpoint api = EndpointFactory.create(GroupEndpoint.class, BASE_ENDPOINT);
        api.delete(groupName);
    }

    public Completable update(String groupId, Group updatedGroup) {
        return Completable.defer(() -> {
                    GroupEndpoint api = EndpointFactory.create(GroupEndpoint.class, BASE_ENDPOINT);
                    api.update(groupId, updatedGroup);
                    return Completable.complete();
                })
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(throwable -> {
                    if (throwable instanceof FeignException) {
                        return Completable.complete();
                    } else {
                        return Completable.error(throwable);
                    }
                });
    }

    /*    public Maybe<Group> update(String groupId, Group updatedGroup) {
        return Maybe.defer(() -> {
                    GroupEndpoint api = EndpointFactory.create(GroupEndpoint.class, BASE_ENDPOINT);
                    api.update(groupId, updatedGroup);
                    return Maybe.just(updatedGroup);
                })
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(throwable -> {
                    if (throwable instanceof FeignException) {
                        return Maybe.empty();
                    } else {
                        return Maybe.error(throwable);
                    }
                });
    }*/
}
