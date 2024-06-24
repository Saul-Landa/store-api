package com.slanda.user_service.services;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.UserAccount;

public interface IPersonService {
    Person findByUserAccount(UserAccount userAccount);
    Person save(Person person);
}
