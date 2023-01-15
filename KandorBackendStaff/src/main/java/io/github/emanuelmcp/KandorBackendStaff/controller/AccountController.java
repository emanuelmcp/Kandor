package io.github.emanuelmcp.KandorBackendStaff.controller;

import io.github.emanuelmcp.KandorBackendStaff.api.service.AccountService;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/accounts/")
public class AccountController {
    private final AccountService service;
    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAll(
            @RequestParam(name = "page", required = false, defaultValue = "0" ) int page ,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size)
    {
        Pageable numberPage = PageRequest.of(page, size);
        Page<Account> accountsPage = service.getPage(numberPage);
        List<Account> accounts = accountsPage.getContent();
        return (accounts.size() == 0) ? new ArrayList<>() : new ArrayList<>(accounts);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account viewAccount(@PathVariable String id){
        Optional<Account> account = service.viewById(id);
        return account.orElse(new Account());
    }

    @PostMapping
    public Account saveAccount(@RequestBody Account account){
        return service.save(account);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No content.
    public void deleteProject(@PathVariable String id){
        service.delete(id);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateProject(@PathVariable String id, @RequestBody @NotNull Account account) {
        return service.update(account);
    }
}
