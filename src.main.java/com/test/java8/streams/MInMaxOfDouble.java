package com.test.java8.streams;

import java.util.Arrays;
import java.util.List;

public class MInMaxOfDouble {

	public static void main(String[] args) {

		List<Double> list = Arrays.asList(9.0, 4.0, 16.0, -6.0, 5.0);

		System.out.println(list.stream().mapToDouble(d->d).max().getAsDouble());

		System.out.println(list.stream().mapToDouble(d->d).min().getAsDouble());
		
	}
}
