package io.github.emanuelmcp.KandorBackendStaff.service;

import io.github.emanuelmcp.KandorBackendStaff.api.service.GroupService;
import io.github.emanuelmcp.KandorBackendStaff.database.GroupRepository;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    @Autowired
    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Group> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

    @Override
    public Optional<Group> viewById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Group save(Group group) {
        return repository.save(group);
    }

    @Override
    public Group update(Group group) {
        group.setId(group.getId());
        return repository.save(group);
    }
}
