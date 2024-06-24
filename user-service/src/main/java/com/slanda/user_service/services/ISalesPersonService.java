package com.slanda.user_service.services;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.SalesPerson;

public interface ISalesPersonService {
    SalesPerson findByPerson(Person person);
    SalesPerson save(SalesPerson salesPerson);
    SalesPerson findByUsername(String username);
}
