package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * So how do you concatenate characters? You could use the libraries. For
 * example, you could use a string buffer You can force the + operator to
 * perform string concatenation rather than addition by ensuring that at least
 * one of its operands is a string. The common idiom is to begin a sequence of
 * concatenations with the empty string (""), as follows: 
 * System.out.print("" + * ’H’ + ’a’);
 */
public class CharLiteralTest {

	@Test
	public void char_literal_addition() {
		
		//performs the obvious string concatenation
		assertEquals("Ha", "H" + "a");
		
		//’H’ and ’a’ are char literals. Because neither
		//operand is of type String, the + operator performs addition rather than string concatenation.
		//The compiler evaluates the constant expression ’H’ + ’a’ by promoting each
		//of the char-valued operands (’H’ and ’a’) to int values through a process known
		//as widening primitive conversion
		//Widening primitive conversion
		//of a char to an int zero extends the 16-bit char value to fill the 32-bit int. In
		//the case of ’H’, the char value is 72 and in the case of ’a’, it is 97, so the expression
		//’H’ + ’a’ is equivalent to the int constant 72 + 97, or 169.
		assertEquals(169, 'H' + 'a');
		
		//performs string concatenation rather than addition
		assertEquals("2 + 2 = 22", "2 + 2 = " + 2 + 2);
	}
}
