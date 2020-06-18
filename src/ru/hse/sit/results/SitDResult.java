package ru.hse.sit.results;

import java.io.PrintStream;
import java.util.List;

import ru.hse.sit.Result;
import ru.hse.sit.pairs.Pair;

public class SitDResult implements Result {
	private final List<Pair> pairs;

	/**
	 * @param pairs
	 */
	public SitDResult(List<Pair> pairs) {
		this.pairs = pairs;
	}

	@Override
	public void printTo(PrintStream out) {
		out.println(this.pairs.size());
		for(Pair pair: this.pairs) {
			out.print(pair.first);
			out.print(" ");
			out.print(pair.second);
			out.println();
		}
	}
}
