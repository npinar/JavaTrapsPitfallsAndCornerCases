package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * When working with large numbers, watch out for overflow—it’s a silent killer.
 * Just because a variable is large enough to hold a result doesn’t mean that
 * the computation leading to the result is of the correct type. When in doubt,
 * perform the entire computation using long arithmetic.
 * 
 */
public class OverflowWithLongDivisionTest {

	@Test
	public void overflow_with_integers() {
		
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		
		//The program must print 1000. Unfortunately, it prints 5.
		//The problem is that the computation of the constant MICROS_PER_DAY does
		//overflow. Although the result of the computation fits in a long with room to spare,
		//it doesn’t fit in an int. The computation is performed entirely in int arithmetic,
		//and only after the computation completes is the result promoted to a long. By
		//then, it’s too late.
		assertEquals(5, MICROS_PER_DAY / MILLIS_PER_DAY);
		
		
		//It’s easy to fix the program by using a long literal in place of an int as the
		//first factor in each product. This forces all subsequent computations in the expression
		//to be done with long arithmetic.
		final long micros_per_day = 24L * 60 * 60 * 1000 * 1000;
		final long millis_per_day = 24L * 60 * 60 * 1000;
		
		assertEquals(1000, micros_per_day / millis_per_day);
	}

}
