package ru.hse.sit;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		new SitDResult(
			Arrays.asList(new Pair(1,2),new Pair(1,3), new Pair(2,3))
		).printTo(System.out);
	}
}
