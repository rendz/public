package com.luxoft.springdata.specifiactions;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.luxoft.springdata.domain.Person;

public class PersonSpecifications {
	public static Specification<Person> findOldGuys() {
		return (root, query, cb) -> {
			CriteriaQuery<Person> q = cb.createQuery(Person.class);
			Root<Person> c = q.from(Person.class);
			return q.select(c).where(cb.greaterThan(c.get("age"), cb.literal(32))).getRestriction();
		};
	}
}
