package com.myjavasolutions.javapuzzlers;

/**
 * 
 * Suppose that you want to write a subclass called AlternateConstructorInvocation, with a constructor
 * that computes the parameter to the superclass constructor by invoking the
 * method SomeOtherClass.func(). The value returned by this method changes
 * unpredictably from call to call. Finally, suppose that you want to store the
 * value that was passed to the superclass constructor in a final instance field
 * of the subclass for future use.
 * 
 * 
 * The following solution is a thread-safe solution. It involves the use of
 * second private constructor.This solution uses an alternate constructor
 * invocation.
 * 
 * This feature allows one constructor in a class to chain to another
 * constructor in the same class. In this case, AlternateConstructorInvocation() chains to the private
 * constructor AlternateConstructorInvocation(int), which performs the required instance
 * initialization. Within the private constructor, the value of the expression
 * SomeOtherClass.func() has been captured in the parameter i and can be stored
 * in the final field param after the superclass constructor returns.
 */
public class AlternateConstructorInvocation extends Thing {

	private final int arg;

	public AlternateConstructorInvocation() {
		//calling some method to capture a value
		//this(SomeOtherClass.func())
		this(5);
	}

	private AlternateConstructorInvocation(int i) {
		super(i);
		arg = i;
	}
}
