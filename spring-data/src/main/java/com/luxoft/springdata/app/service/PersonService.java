package com.luxoft.springdata.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luxoft.springdata.domain.Person;
import com.luxoft.springdata.repository.PersonRepository;
import com.luxoft.springdata.repository.SimplePersonRepository;
import com.luxoft.springdata.specifiactions.PersonPredicates;
import com.luxoft.springdata.specifiactions.PersonSpecifications;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private SimplePersonRepository simplePersonRepository;

	@Transactional
	public void txTest() {
		System.out.println("\n\nTransactions test");
		Person person = new Person("Daniel", 32);
		personRepository.saveAndFlush(person);
		System.out.println("Saved...");

		System.out.println("New Tx");
		simplePersonRepository.findAll().stream().map((p) -> p.toString()).forEach(System.out::println);

		System.out.println("Same Tx");
		personRepository.findAll().stream().map((p) -> p.toString()).forEach(System.out::println);

		System.out.println("Find by age");
		simplePersonRepository.findByAge(32).stream().map((p) -> p.toString()).forEach(System.out::println);
	}

	@Transactional
	public void findersTest() {
		System.out.println("\n\nFinder methods");
		personRepository.save(new Person("Daniel", 32));

		System.out.println("Find by age");
		System.out.println(simplePersonRepository.findByAge(32));
	}

	@Transactional
	public void jpaSpecificationTest() {
		System.out.println("\n\nJpa Specification");

		personRepository.save(new Person("Daniel", 25));
		personRepository.save(new Person("Daniel", 30));
		personRepository.save(new Person("Daniel", 34));

		for (Person p : personRepository.findAll(PersonSpecifications.findOldGuys())) {
			System.out.println(p);
		}
	}

	@Transactional
	public void querydslPredicatesTest() {
		System.out.println("\n\nQuerydsl predicates");
		personRepository.save(new Person("Daniel", 25));
		personRepository.save(new Person("Daniel", 33));
		personRepository.save(new Person("Daniela", 34));

		for (Person p : personRepository.findAll(PersonPredicates.OLD_DANIEL)) {
			System.out.println(p);
		}
	}

	public void jpaQueriesTest() {
		System.out.println("\n\nJPA Queries test");
		personRepository.save(new Person("Daniel", 15));
		personRepository.save(new Person("Daniel", 33));
		personRepository.save(new Person("Daniela", 34));

		System.out.println("\nFetch voters");
		simplePersonRepository.fetchVoters().stream().map((p) -> p.toString()).forEach(System.out::println);

		System.out.println("\nFetch by name indexed");
		simplePersonRepository.fetchByNameIndexed("Dani%").stream().map((p) -> p.toString())
				.forEach(System.out::println);

		System.out.println("\nFetch by name named");
		simplePersonRepository.fetchByNameIndexed("Daniela").stream().map((p) -> p.toString())
				.forEach(System.out::println);
	}
}
