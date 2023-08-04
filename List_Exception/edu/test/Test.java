package com.edu.test;

public class Test {

	public static void main(String[] args) {
		
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		
		///////////////////////////////////
		
		String str3 = "JAVA";
		String str4 = "JAVA";
		
		System.out.println(str1==str2); //false
		System.out.println(str1.equals(str2)); //true
		
		System.out.println(str3==str4); //true
		System.out.println(str3.equals(str4));
	}
}
