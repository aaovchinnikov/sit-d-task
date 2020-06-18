package ru.hse.sit;

import java.util.Scanner;

public class StdInInput implements Input {
	private final Scanner scanner;
	
	/**
	 * @param scanner
	 */
	public StdInInput(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public int n() {
		
		return 0;
	}

	@Override
	public int k() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] skiis() {
		// TODO Auto-generated method stub
		return null;
	}
}
