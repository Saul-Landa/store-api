package com.slanda.user_service.services.Implements;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.UserAccount;
import com.slanda.user_service.repositories.PersonRepository;
import com.slanda.user_service.services.IPersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findByUserAccount(UserAccount userAccount) {
        return personRepository.findByUserAccount(userAccount);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
