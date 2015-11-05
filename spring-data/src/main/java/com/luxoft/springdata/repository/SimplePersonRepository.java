package com.luxoft.springdata.repository;

import java.util.List;
import java.util.Set;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.findShortestPaths;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luxoft.springdata.domain.Person;

public interface SimplePersonRepository extends Repository<Person, Long>, SimplePersonRepositoryExtension {
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	Set<Person> findAll();

	Person findByName(String name);

	List<Person> findByNameEndingWith(String name);
	
	List<Person> findByAge(Integer age);

	@Query("select p from Person p where p.age >= 18")
	List<Person> fetchVoters();

	@Query("select p from Person p where p.name like ?1")
	List<Person> fetchByNameIndexed(String name);

	@Query("select p from Person p where p.name like :name")
	List<Person> fetchByNameNamed(@Param("name") String name);
}
