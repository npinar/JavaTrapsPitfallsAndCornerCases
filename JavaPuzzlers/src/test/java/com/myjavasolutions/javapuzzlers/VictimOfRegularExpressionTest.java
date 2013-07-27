package com.myjavasolutions.javapuzzlers;

import static junit.framework.Assert.assertEquals;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 * Be careful when using unfamiliar library methods. Also, regular expressions
 * are tricky: Problems tend to show up at run time rather than compile time.
 * the following program's correct behavior is platform dependent. Not all file
 * systems use the slash character to separate hierarchical filename components.
 * To get a valid filename for the platform on which you are running, you should
 * use the correct platform-dependent separator character in place of the slash.
 * 
 */
public class VictimOfRegularExpressionTest {

	@Test
	public void fully_qualifiled_class_name() {
		
		//String.replaceAll takes a regular expression as its
		//first parameter, not a literal sequence of characters. 
		//The regular expression "." matches any single character, 
		//and so every character of the class name is replaced by a slash,
		//producing the following output.
		String actual = VictimOfRegularExpressionTest.class.getName().replaceAll(".", "/") + ".class";
		assertEquals("/////////////////////////////////.class", actual);
		
		//To match only the period character, the period in the regular expression must
		//be escaped by preceding it with a backslash (\).
		actual = VictimOfRegularExpressionTest.class.getName().replaceAll("\\.", "/") + ".class";
		assertEquals("com/VictimOfRegularExpressionTest.class", actual);
		
		//To solve this kind of problem, release 5.0 provides the new static method
		//java.util.regex.Pattern.quote. It takes a string as a parameter and adds any
		//necessary escapes, returning a regular expression string that matches the input
		//string exactly. Here is how the program looks when modified to make use of this
		//method:
		actual = VictimOfRegularExpressionTest.class.getName().replaceAll(Pattern.quote("."), "/") + ".class";
		assertEquals("com/VictimOfRegularExpressionTest.class", actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void fully_qualifiled_class_name_with_file_separator() {
		
		//If the file separator is a slash, as it is on UNIX, the program will work. 
		//If, however, the file separator is a backslash, as it is on Windows,
		//the program will throw IllegalArgumentException
		/*
		 * What went wrong on Windows? It turns out that the second parameter of
		 * String.replaceAll is a not an ordinary string but a replacement
		 * string, as defined in the java.util.regex specification [Java-API]. A
		 * backslash appearing in a replacement string escapes the following
		 * character, causing it to be treated literally. When you run the
		 * program on Windows, the replacement string is a lone backslash
		 * character, which is invalid.
		 */
		System.out.println(VictimOfRegularExpressionTest.class.getName().replaceAll("\\.", File.separator) + ".class");
		
		/*
		 * Release 5.0 provides not one but two new methods that solve it. One
		 * is java.util.regex.Matcher.quoteReplacement, which translates a
		 * string into the corresponding replacement string. Here is how to fix
		 * the program by using this method:
		 */
		System.out.println(VictimOfRegularExpressionTest.class.getName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + ".class");

		/*
		 * The second method introduced in release 5.0 provides an even better
		 * solution. This method, String.replace(CharSequence, CharSequence),
		 * does the same thing as String.replaceAll, but treats both the pattern
		 * and the replacement as literal strings. Here is how to fix the
		 * program by using this method:
		 */
		System.out.println(VictimOfRegularExpressionTest.class.getName().replace(".", File.separator) + ".class");
	}
}
