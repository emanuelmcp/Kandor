package io.github.emanuelmcp.KandorBackendStaff.controller;

import io.github.emanuelmcp.KandorBackendStaff.api.service.GroupService;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/groups/")
public class GroupController {
    private final GroupService service;

    @Autowired
    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> findAll() {
        List<Group> groups = service.getAll();
        return (groups.size() == 0) ? new ArrayList<>() : new ArrayList<>(groups);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group viewGroup(@PathVariable String id){
        Optional<Group> account = service.viewById(id);
        return account.orElse(new Group());
    }

    @PostMapping
    public Group saveAccount(@RequestBody Group group){
        return service.save(group);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No content.
    public void deleteProject(@PathVariable String id){
        service.delete(id);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group updateGroup(@PathVariable String id, @RequestBody @NotNull Group account) {
        return service.update(account);
    }
}
