package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CircularityClassInitializationTest {

	@Test
	public void invalid_belt_size() {
		
		assertEquals(-1930, Elvis.INSTANCE.beltSize());
	}
}
