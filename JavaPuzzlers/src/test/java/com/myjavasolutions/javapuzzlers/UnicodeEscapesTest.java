package com.myjavasolutions.javapuzzlers;

import org.junit.Test;

/**
 * 
 * Avoid Unicode escapes except where they are truly necessary.
 * 
 * In the following folder location, if you take the j out from junit, this code
 * will not compile. 
 * C:\TestRoot\something\junit
 * The problem is in the third line of the comment, which contains the characters \\units. 
 * These characters
 * begin with a backslash (\) followed by the letter u, which denotes the start
 * of a Unicode escape. Unfortunately, these characters are not followed by four
 * hexadecimal digits, so the Unicode escape is ill-formed, and the compiler is
 * required to reject the program. Unicode escapes must be well formed, even if
 * they appear in comments. Replace the junit with \u0022 and see what happens.
 */
public class UnicodeEscapesTest {

	@Test
	public void unicode_escape() {
		
		//In the folowing comment if you take the //(in front of is) out
		//this code would not compile. And the reason why is:
		//this escape represents the linefeed character,
		//and the compiler duly translates it before discarding the comment. Unfortunately,
		//this linefeed character is the first line terminator after the two slash characters that
		//begin the comment (//) and so terminates the comment. The words following
		//the escape (is Unicode representation of linefeed (LF)) are therefore
		//not part of the comment; nor are they syntactically valid.
		
		// Note: \u000A //is Unicode representation of linefeed (LF)
		
		System.out.print("Hell");
		System.out.println("o world");
	}
}
