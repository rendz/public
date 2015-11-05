package com.luxoft.springdata.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.luxoft.springdata.app.service.PersonService;
import com.luxoft.springdata.repository.SimplePersonRepository;

@Component
public class CmdRunner implements CommandLineRunner {
	@Autowired
	private PersonService personService;

	@Autowired
	SimplePersonRepository simplePersonRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running...");
		// personService.txTest();

		// personService.findersTest();

		// personService.querydslPredicatesTest();

		// personService.jpaSpecificationTest();

		// simplePersonRepo.findWithCustomMethod(1l);

		personService.jpaQueriesTest();
	}
}
