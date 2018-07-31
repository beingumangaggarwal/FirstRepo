package com.foreach;

import java.util.ArrayList;
import java.util.List;

public class practice6 {

	public static void main(String[] args) {

		List<Integer> items = new ArrayList<>();
		items.add(4);
		items.add(9);
		items.add(2);
		items.add(5);
		items.add(7);

		items.forEach(i->System.out.println(i));
	}

}
