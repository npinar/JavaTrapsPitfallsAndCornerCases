package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.fail;

import org.junit.Test;

public class BitwiseAndTest {

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void bitwise_and_operator_evaluates_both_operands() {
		
		int[][] tests = { { 6, 5, 4, 3, 2, 1 }, { 1, 2 },
				{ 1, 2, 3 }, { 1, 2, 3, 4 }, { 1 } };
		
		//&& operator does not evaluate its right operand if its left operand evaluates to false
		if(tests.length >= 6 && tests[2][6] == 1) {
			fail();
		}

		//& operator always evaluates both of its operands.
		//So, the following code will produce ArrayIndexOutOfBoundsException
		if(tests.length >= 6 & tests[2][6] == 2) {
			fail();
		}
	}
}

