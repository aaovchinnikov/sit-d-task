package ru.hse.sit;

import java.io.PrintStream;
import java.util.List;

public class SitDResult implements Result {
	private final List<Pair> pairs;

	/**
	 * @param pairs
	 */
	public SitDResult(List<Pair> pairs) {
		this.pairs = pairs;
	}

	@Override
	public void print(PrintStream out) {
		out.println(this.pairs.size());
		for(Pair pair: this.pairs) {
			out.print(pair.first);
			out.print(" ");
			out.print(pair.second);
			out.println();
		}
	}
}
