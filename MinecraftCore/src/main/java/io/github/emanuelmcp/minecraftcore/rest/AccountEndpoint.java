package io.github.emanuelmcp.minecraftcore.rest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.emanuelmcp.minecraftcore.models.Account;
@Headers("Accept: application/json")
public interface AccountEndpoint {
    @RequestLine("GET /accounts/{userId}")
    Account getAccount(@Param("userId") String userId);
    @RequestLine("POST /accounts/")
    @Headers("Content-Type: application/json")
    Account saveAccount(Account account);
}