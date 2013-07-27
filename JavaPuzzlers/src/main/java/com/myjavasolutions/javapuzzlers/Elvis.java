package com.myjavasolutions.javapuzzlers;

import java.util.Calendar;

/**
 * 
 * This program suffers a problem caused by a circularity in the order of class
 * initialization First, static fields are set to their default values Next,
 * static field initializers are executed in order of appearance.
 * 
 * 
 * The constructor initializes beltSize to an expression involving the static
 * field CURRENT_YEAR. Normally, reading a static field is one of the things
 * that causes a class to be initialized, but we are already initializing the
 * class Elvis. Recursive initialization attempts are simply ignored.
 * Consequently, the value of CURRENT_YEAR still has its default value of 0.
 * That is why Elvis’s belt size turns out to be -1930.
 * 
 * Finally, returning from the constructor to complete the class initialization
 * of Elvis, we initialize the static field CURRENT_YEAR to 2006, assuming
 * you’re running the program in 2006. Unfortunately, it is too late for the now
 * correct value of this field to affect the computation of
 * Elvis.INSTANCE.beltSize, which already has the value -1930. This is the value
 * that will be returned by all subsequent calls to Elvis.INSTANCE.beltSize().
 * 
 * This program shows that it is possible to observe a final static field before
 * it is initialized, when it still contains the default value for its type.
 * That is counterintuitive, because we usually think of final fields as
 * constants. Final fields are constants only if the initializing expression is
 * a constant expression
 * 
 * To fix a class initialization cycle, reorder the static field initializers so
 * that each initializer appears before any initializers that depend on it.
 */
public class Elvis {

	public static final Elvis INSTANCE = new Elvis();
	private final int beltSize;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	private Elvis() {
		beltSize = CURRENT_YEAR - 1930;
	}

	public int beltSize() {
		return beltSize;
	}
}
