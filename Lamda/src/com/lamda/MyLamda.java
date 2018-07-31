package com.lamda;

public class MyLamda {

	public static void main(String[] args) {

		MylamdaIn myLamdaFunction = () -> System.out.println("Hey!!");

		myLamdaFunction.foo();

	}

	interface MylamdaIn {

		void foo();

	}

}
