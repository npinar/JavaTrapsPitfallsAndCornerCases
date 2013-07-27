package com.myjavasolutions.javapuzzlers;

/**
 * 
 * overload resolution can be confusing. Avoid overloading where possible.
 * 
 * Java’s overload resolution process operates in two phases. The first phase
 * selects all the methods or constructors that are accessible and applicable.
 * The second phase selects the most specific of the methods or constructors
 * selected in the first phase. One method or constructor is less specific than
 * another if it can accept any parameters passed to the other
 * 
 * In our program, both constructors are accessible and applicable. The
 * constructor OverloadedConstructors(Object) accepts any parameter passed to
 * OverloadedConstructors(double[]), so OverloadedConstructors(Object) is less
 * specific. (Every double array is an Object, but not every Object is a double
 * array.) The most specific constructor is therefore
 * OverloadedConstructors(double[])
 * 
 * The key to understanding this puzzle is that the test for which method or
 * constructor is most specific does not use the actual parameters: They are
 * used only to determine which overloadings are applicable. Once the compiler
 * determines which overloadings are applicable and accessible, it selects the
 * most specific overloading, using only the formal parameters: the parameters
 * appearing in the declaration.
 */
public class OverloadedConstructors {

	String result = "";
	
	public OverloadedConstructors(Object o) {
		this.result = "Object";
	}

	public OverloadedConstructors(double[] dArray) {
		this.result = "double array";
	}

	public String getResult() {
		return result;
	}
}

