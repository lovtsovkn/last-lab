package edu.spring.data;

import edu.spring.data.domain.Person;
import edu.spring.data.domain.repository.CountryRepository;
import edu.spring.data.domain.repository.PersonRepository;
import edu.spring.data.domain.repository.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;
//import ru.otus.spring10.repostory.PersonRepository;

import javax.annotation.PostConstruct;
import java.util.List;

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
        personRepository.save(new Person("Pushkin"));
        personRepository.save(new Person("Gogol"));

        Specification<Person> specification = PersonSpecification.all();
        if (true) {
            specification = specification.and(PersonSpecification.hasNameLike("us"));
        }

        List<Person> personList = personRepository.findAll(specification);
        personList.forEach(System.out::println);

//        countryRepository.save(new Country("Russia", 150000000));
//        countryRepository.save(new Country("Belarus", 30000000));
//        List<Country> result = countryRepository.findByPopulation(30000000);
//        System.out.println(result.size());
//        System.out.println(result.get(0).getName());
    }
}
