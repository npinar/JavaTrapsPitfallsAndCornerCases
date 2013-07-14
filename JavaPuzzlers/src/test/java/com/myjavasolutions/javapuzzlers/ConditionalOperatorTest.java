package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

 /** 1. If the second and third operands have the same type, that is the type
 * of the conditional expression. 2. If one of the operands is of type T where T
 * is byte, short, or char and the other operand is a constant expression of
 * type int whose value is representable in type T, the type of the conditional
 * expression is T. 3. Otherwise, binary numeric promotion is applied to the
 * operand types, and the type of the conditional expression is the promoted
 * type of the second and third operands.
 * 
 * It is generally best to use the same type for the second and third operands
 * in conditional expressions.
 **/

 public class ConditionalOperatorTest {

	@Test
	public void conditional_operator() {
		
		char x = 'X';
		int i = 0;
		
		//point 2 applies to the following expression and its return type is char
		assertEquals('X', true ? x : 0);
		
		//Point 3 applies to the following conditional expression, 
		//and its return type is the result of applying binary numeric promotion
		//to int and char, which is int
		assertEquals(88, false ? i : x);
	}
}
