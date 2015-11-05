package com.luxoft.springdata.specifiactions;

import com.luxoft.springdata.domain.QPerson;
import com.mysema.query.types.expr.BooleanExpression;

public class PersonPredicates {
	public final static BooleanExpression OLD_GUYS = QPerson.person.age.gt(30);
	public final static BooleanExpression DANIELS = QPerson.person.name.like("Daniel");
	public final static BooleanExpression OLD_DANIEL = OLD_GUYS.and(DANIELS);
}
