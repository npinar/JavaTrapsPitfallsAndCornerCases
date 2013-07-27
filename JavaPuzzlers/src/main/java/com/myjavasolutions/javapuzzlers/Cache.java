package com.myjavasolutions.javapuzzlers;

/**
 * class initialization executes static initializers in the order they appear in
 * the source. Use either eager initialization or lazy initialization, never
 * both. If the time and space cost to initialize a field is low or the field is
 * required in every execution of the program, eager initialization is
 * appropriate. If the cost is high and the field might not be required in some
 * executions, lazy initialization may be preferable.
 * 
 * The Cache class could be repaired either by reordering the static
 * initializations so the initialized field was not reset to false after sum was
 * initialized or by removing the explicit static initialization of the
 * initialized field.
 * 
 */
class Cache {
	static {
		initializeIfNecessary();
	}
	private static int sum;

	public static int getSum() {
		initializeIfNecessary();
		return sum;
	}

	private static boolean initialized = false;

	private static synchronized void initializeIfNecessary() {
		if (!initialized) {
			for (int i = 0; i < 100; i++)
				sum += i;
			initialized = true;
		}
	}
}
