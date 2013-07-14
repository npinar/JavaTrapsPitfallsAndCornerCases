package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * You may be aware that compile-time constants of type String are interned. In
 * other words, any two constant expressions of type String that designate the
 * same character sequence are represented by identical object references. If
 * initialized with constant expressions, both pig and dog would indeed refer to
 * the same object, but dog is not initialized with a constant expression.
 * 
 * When using the string concatenation operator, always parenthesize nontrivial
 * operands. Arguably, the program is still broken. Your code should rarely, if
 * ever, depend on the interning of string constants.
 * 
 * When comparing object references, you should use the equals method in
 * preference to the == operator unless you need to compare object identity
 * rather than value.
 */

public class EqualTest {

	@Test
	public void are_two_strings_equal() {
		
		final String pig = "length: 10";
		final String dog = "length: " + pig.length();
		
		//The following statement returns false and Animals are equal is not printed out
		//The + operator, whether used for addition or string concatenation,
		//binds more tightly than the == operator. Therefore, the parameter of the println
		//method is evaluated like this: 
		//System.out.println(("Animals are equal: " + pig) == dog);
		assertFalse("Animals are equal: " + pig == dog);
		
		//they are not equal because dog is not initialized with a constant expression
		assertFalse((pig == dog));
		
		final String cat = "length: 10";
		//now they are equal because  any two constant expressions of type String that designate the
		//same character sequence are represented by identical object references. 
		assertTrue((pig == cat));
	}
}
