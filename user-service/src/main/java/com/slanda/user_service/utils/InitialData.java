package com.slanda.user_service.utils;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.Role;
import com.slanda.user_commons.models.SalesPerson;
import com.slanda.user_commons.models.UserAccount;
import com.slanda.user_service.services.IPersonService;
import com.slanda.user_service.services.IRoleService;
import com.slanda.user_service.services.ISalesPersonService;
import com.slanda.user_service.services.IUserAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {

    private final IRoleService roleService;
    private final IPersonService personService;
    private final ISalesPersonService salesPersonService;
    private final IUserAccountService userAccountService;

    public InitialData(IRoleService roleService, IPersonService personService, ISalesPersonService salesPersonService, IUserAccountService userAccountService) {
        this.roleService = roleService;
        this.personService = personService;
        this.salesPersonService = salesPersonService;
        this.userAccountService = userAccountService;
    }

    @Override
    public void run(String... args) {
        try {
            String roleName = "ROLE_SALES";
            Role role = roleService.findByName(roleName);
            if ( role == null ) {
                role = roleService.save(roleName);
            }

            String username = "sales_person";
            UserAccount userAccount = userAccountService.findByUsername(username).orElse(null);
            if ( userAccount == null ) {
                userAccount = userAccountService.save(UserAccount.builder()
                                .username(username)
                                .password("$ales.2024")
                                .isEnabled(true)
                                .role(role)
                                .build());
            }

            Person person = personService.findByUserAccount(userAccount);
            if ( person == null ) {
                person = personService.save(Person.builder()
                                .firstName("Jorge")
                                .lastName("Flores")
                                .userAccount(userAccount)
                                .build());
            }

            SalesPerson salesPerson = salesPersonService.findByPerson(person);
            if ( salesPerson == null ) {
                salesPersonService.save(SalesPerson.builder()
                                .employeeNumber("84625791")
                                .person(person)
                                .build());
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
