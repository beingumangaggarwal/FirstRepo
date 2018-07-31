package com.lamda;

public class LamdaImpl {

	public static void main(String[] args) {

		Lamda obj = (int a) -> {
			System.out.println("Hii"+a);

		};

		obj.display(6);
	}
}
