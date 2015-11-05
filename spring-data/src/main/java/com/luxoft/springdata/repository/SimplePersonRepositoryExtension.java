package com.luxoft.springdata.repository;

import com.luxoft.springdata.domain.Person;

public interface SimplePersonRepositoryExtension {
	Person findWithCustomMethod(Long id);
}
