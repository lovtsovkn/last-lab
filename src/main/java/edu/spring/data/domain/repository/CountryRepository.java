package edu.spring.data.domain.repository;

import edu.spring.data.domain.Country;
import edu.spring.data.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findByPopulation(int name);

}
