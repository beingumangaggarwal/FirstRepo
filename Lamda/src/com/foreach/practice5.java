package com.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.*;

public class practice5 {

	public static void main(String[] args) {

		IntStream.range(1, 11).skip(5).forEach(x->System.out.println(x));
		
		String [] names ={"ABCD","UMANG","Shubham","Sumit"};
		
		Arrays.stream(names).filter(x->x.startsWith("S")).sorted().forEach(System.out::println);
		
		Arrays.stream(new int[] {2,3,6,7,9,11}).map(x->x*x).average().ifPresent(System.out::println);
		
		double total = Stream.of(7.3,1.5,4.8).reduce(0.0, (Double a , Double b)->a+b);
		
		System.out.println("Total = " + total);
		
	}

	
}
