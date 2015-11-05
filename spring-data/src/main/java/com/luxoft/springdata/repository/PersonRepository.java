package com.luxoft.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.luxoft.springdata.domain.Person;

//@RepositoryRestResource(collectionResourceRel = "person", path = "people")
public interface PersonRepository
		extends JpaRepository<Person, Long>, QueryDslPredicateExecutor<Person>, JpaSpecificationExecutor<Person> {

}
