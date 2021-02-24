package edu.spring.data.domain.repository;

import edu.spring.data.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findByPopulation(int name);

}
