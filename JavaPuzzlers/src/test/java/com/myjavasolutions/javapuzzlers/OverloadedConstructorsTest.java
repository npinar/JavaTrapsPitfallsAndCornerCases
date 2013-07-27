package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class OverloadedConstructorsTest {

	@Test
	public void confusing_constructor() {
		
		OverloadedConstructors overloadedConstructors = new OverloadedConstructors(null);
		assertEquals("double array", overloadedConstructors.getResult());
	}
}
