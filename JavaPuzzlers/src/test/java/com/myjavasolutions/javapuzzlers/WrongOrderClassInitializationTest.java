package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class WrongOrderClassInitializationTest {

	@Test
	public void nums_added_twice() {
		assertEquals(9900, Cache.getSum());
	}

}
