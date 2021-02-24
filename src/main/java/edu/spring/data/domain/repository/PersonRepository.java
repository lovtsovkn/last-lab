package edu.spring.data.domain.repository;

import edu.spring.data.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer>,
        JpaSpecificationExecutor<Person> {

    //@Query("select p from Person p where  p.name = :name")
    Optional<Person> findByName(@Param("name") String name);

}
