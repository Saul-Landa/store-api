package com.slanda.user_service.repositories;

import com.slanda.user_commons.models.Person;
import com.slanda.user_commons.models.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {
    SalesPerson findByPerson(Person person);
}
