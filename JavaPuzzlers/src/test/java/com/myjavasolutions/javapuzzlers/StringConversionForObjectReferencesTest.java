package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * What is the behavior of invoking toString on a non-null char array? Arrays
 * inherit the toString method from Object [JLS 10.7], whose specification says,
 * “Returns a string consisting of the name of the class of which the object is
 * an instance, the at-sign character ’@’, and the unsigned hexadecimal
 * representation of the hash code of the object” [Java-API].
 * 
 * char arrays are not strings. To convert a char array to a string, invoke
 * String.valueOf(char[]).
 */
public class StringConversionForObjectReferencesTest {

	@Test
	public void test() {

		String letters = "ABC";
		char[] numbers = { '1', '2', '3' };
		
		//String conversion for object references which include arrays, is defined as follows
		//If the reference is null, it is converted to the string "null". Otherwise, the conversion
		//is performed as if by an invocation of the toString method of the referenced
		//object with no arguments; but if the result of invoking the toString
		//method is null, then the string "null" is used instead.
		System.out.println(letters + " easy as " + numbers);
		
		//The following statement will also print ABC easy as [C@1a71e93
		//assertEquals(123, numbers);
		
		//There are two ways to fix it.
		//1) The char[] overloading of println prints all of the characters contained in the array.
		System.out.println(numbers);
		
		//2)convert the array to a string before invoking string concatenation
		assertEquals("ABC123", letters + String.valueOf(numbers));
	}
}
