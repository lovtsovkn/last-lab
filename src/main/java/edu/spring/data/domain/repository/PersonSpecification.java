package edu.spring.data.domain.repository;

import edu.spring.data.domain.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecification {

    public static Specification<Person> all() {
        return ((root, criteriaQuery, cb) -> cb.isTrue(cb.literal(Boolean.TRUE)));
    }

    public static Specification<Person> hasName(String name) {
        return ((root, criteriaQuery, cb) -> cb.equal(root.get("name"), name));
    }

    public static Specification<Person> hasNameLike(String name) {
        return ((root, criteriaQuery, cb) -> cb.like(root.get("name"), "%" + name + "%"));
    }

}
