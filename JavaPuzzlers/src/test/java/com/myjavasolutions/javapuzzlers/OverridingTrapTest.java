package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * Never qualify a static method invocation with an expression.
 * When you invoke a static method, you typically qualify it with a class rather
than an expression: for example Dog.bark or Basenji.bark.
 *
 */
public class OverridingTrapTest {

	@Test
	public void not_correct_overriding() {
		
		
		//The problem is that bark is a static method, and there is no dynamic dispatch on static methods
		//When a program calls a static method, the method to be invoked is selected at	compile time,
		//Static methods cannot be overridden. To avoid confusion, do not hide static methods.
		
		//To fix this program, simply remove the static modifier from the two bark
		//method declarations. Then the bark method in Basenji will override rather than
		//hide the bark method in Dog, and the program will print woof instead of
		//woof woof. With overriding, you get dynamic dispatch; with hiding, you don’t.
		
		Dog woofer = new Dog();
		Dog nipper = new Basenji();
		assertEquals("woof", woofer.bark());
		assertEquals("woof", nipper.bark());
	}

}
