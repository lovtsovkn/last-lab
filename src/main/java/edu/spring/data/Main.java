package edu.spring.data;

import edu.spring.data.domain.entity.Country;
import edu.spring.data.domain.repository.CountryRepository;
import edu.spring.data.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init() {
        countryRepository.save(new Country("Russia", 150000000));
        countryRepository.save(new Country("Belarus", 10000000));
    }
}
