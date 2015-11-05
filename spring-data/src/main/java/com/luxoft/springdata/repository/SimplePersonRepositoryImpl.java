package com.luxoft.springdata.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.luxoft.springdata.domain.Person;

public class SimplePersonRepositoryImpl implements SimplePersonRepositoryExtension {
	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person findWithCustomMethod(Long id) {
		Person p = personRepo.findOne(id);
		System.out.println("findWithCustomMethod: " + p);
		return p;
	}
}
