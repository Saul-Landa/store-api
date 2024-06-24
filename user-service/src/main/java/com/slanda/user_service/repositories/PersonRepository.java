package com.slanda.user_service.repositories;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUserAccount(UserAccount userAccount);
}
