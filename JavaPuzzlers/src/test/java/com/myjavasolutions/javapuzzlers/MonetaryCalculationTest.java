package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Avoid float and double where exact answers are required; for monetary
 * calculations, use int, long, or BigDecimal.
 * 
 **/
public class MonetaryCalculationTest {

	@Test
	public void monetary_calculation() {

		// The problem with the following statement is that the number 1.1 can’t
		// be represented
		// exactly as a double, so it is represented by the closest double
		// value. The program subtracts
		// this value from 2. Unfortunately, the result of this calculation is
		// not the closest double value
		// to 0.9. The shortest representation of the resulting double value is
		// 0.8999999999999999.
		assertEquals(0.8999999999999999, 2.00 - 1.10);

		// One way to solve the problem is to use an integral type, such as int
		// or long,
		// and to perform the computation in cents. If you go this route, make
		// sure the
		// integral type is large enough to represent all the values you will
		// use in your program.
		assertEquals("90 cents", (200 - 110) + " cents");

		// The best solution:
		// Use BigDecimal to solve the problem, which performs exact decimal
		// arithmetic.
		// Always use the BigDecimal(String) constructor, never
		// BigDecimal(double). The latter
		// constructor creates an instance with the exact value of its argument:
		// new BigDecimal(.1)
		// returns a BigDecimal representing
		// 0.1000000000000000055511151231257827021181583404541015625.
		BigDecimal expected = new BigDecimal("0.90");
		assertEquals(expected, new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
	}

}
