package com.myjavasolutions.javapuzzlers;

import org.junit.Test;

/**
 * misleading comments and extraneous code cause confusion. Write comments
 * carefully and keep them up to date. Excise dead code.
 * 
 */
public class LabelTrickTest {

	@Test
	public void label_following_with_comment() {
		
		System.out.print("iexplore:");
		
		//The URL that appears in the middle of the program
		//is a statement label followed by an end-of-line comment
		http://www.google.com;
			
		System.out.println(":maximize");
	}

}
