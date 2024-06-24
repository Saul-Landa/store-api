package com.slanda.user_service.services;

import com.slanda.user_commons.models.UserAccount;

import java.util.Optional;

public interface IUserAccountService {
    Optional<UserAccount> findByUsername(String username);
    UserAccount save(UserAccount userAccount);
}
