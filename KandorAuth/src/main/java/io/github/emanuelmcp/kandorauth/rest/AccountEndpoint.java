package io.github.emanuelmcp.kandorauth.rest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.emanuelmcp.kandorauth.entity.Account;

public interface AccountEndpoint {
    @RequestLine("GET /accounts/{userId}")
    Account getAccount(@Param("userId") String userId);
    @RequestLine("POST /accounts/")
    @Headers("Content-Type: application/json")
    void saveAccount(Account account);
}
