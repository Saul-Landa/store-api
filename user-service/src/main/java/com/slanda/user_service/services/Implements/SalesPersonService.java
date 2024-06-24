package com.slanda.user_service.services.Implements;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.SalesPerson;
import com.slanda.user_commons.models.UserAccount;
import com.slanda.user_service.repositories.SalesPersonRepository;
import com.slanda.user_service.services.IPersonService;
import com.slanda.user_service.services.ISalesPersonService;
import com.slanda.user_service.services.IUserAccountService;
import org.springframework.stereotype.Service;

@Service
public class SalesPersonService implements ISalesPersonService {

    private final IPersonService personService;
    private final IUserAccountService userAccountService;
    private final SalesPersonRepository salesPersonRepository;

    public SalesPersonService(IPersonService personService, IUserAccountService userAccountService, SalesPersonRepository salesPersonRepository) {
        this.personService = personService;
        this.userAccountService = userAccountService;
        this.salesPersonRepository = salesPersonRepository;
    }

    @Override
    public SalesPerson findByPerson(Person person) {
        return salesPersonRepository.findByPerson(person);
    }

    @Override
    public SalesPerson save(SalesPerson salesPerson) {
        return salesPersonRepository.save(salesPerson);
    }

    @Override
    public SalesPerson findByUsername(String username) {
        UserAccount userAccount = userAccountService.findByUsername(username).orElse(null);
        Person person = personService.findByUserAccount(userAccount);

        return findByPerson(person);
    }


}
