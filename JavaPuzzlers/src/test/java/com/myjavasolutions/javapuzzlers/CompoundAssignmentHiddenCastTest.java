package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * do not use compound assignment operators on variables of type byte, short, or
 * char When using compound assignment operators on variables of type int,
 * ensure that the expression on the right-hand side is not of type long, float,
 * or double. When using compound assignment operators on variables of type
 * float, ensure that the expression on the right-hand side is not of type
 * double. These rules are sufficient to prevent the compiler from generating
 * dangerous narrowing casts.
 * 
 * The += operator allows its right-hand operand to be of any type if the
 * variable on the left-hand side is of type String, in which case the operator
 * performs string concatenation.
 */
public class CompoundAssignmentHiddenCastTest {

	@Test
	public void hidden_cast_with_compound_assignment() {
		
		short x = 0;
		int i = 123456;
		
		//Contains a hidden cast!
		//Compound assignment operators silently generate a cast. If the
		//type of the result of the computation is wider than that of the variable, the generated
		//cast is a dangerous narrowing cast. Such casts can silently discard precision	or magnitude.
		x += i; 
		assertEquals(-7616, x);
		
		//the following generates compiler error
		//x = x + i;
		
		Object someObject = "Buy ";
		String someString = "Effective Java!";
		
		//The simple assignment is legal because someObject + someString is of type String, and String is
		//assignment compatible with Object:
		someObject = someObject + someString;
		
		//The following compound assignment is illegal because the left-hand side has an object reference
		//type other than String
		//someObject += someString;
	}
}

