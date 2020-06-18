package ru.hse.sit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public final class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      final int n = scanner.nextInt();
      if (!(1 <= n && n <= 200_000)) {
        return;
      }
      final int k = scanner.nextInt();
      if (!(0 <= k && k <= 1_000_000_000)) {
        return;
      }
      final int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = scanner.nextInt();
        if (!(1 <= array[i] && array[i] <= 1_000_000_000)) {
          return;
        }
      }
      final List<Pair> pairs = pairs(array, k);
      System.out.println(pairs.size());
      for (Pair pair : pairs) {
        System.out.println((pair.first + 1) + " " + (pair.second + 1));
      }
    }
  }

  private static List<Pair> pairs(int[] array, int k){
    final List<Pair> totalPairs = new ArrayList<Pair>();
    for(int i =0; i < array.length ; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (Math.abs(array[i] - array[j]) <= k) {
          totalPairs.add(new Pair(i, j));
        }
      }
    }
    final List<Pair> returnPairs = new ArrayList<Pair>();
    while(!totalPairs.isEmpty()) {
      int bestSize = 0;
      Pair bestPair = null;
      for(Pair pair: totalPairs) {
        final List<Pair> pairs = new ArrayList<Pair>(totalPairs);
        removePair(pairs, pair);
        if(pairs.size() >= bestSize) {
          bestPair = pair;
          bestSize = pairs.size(); 
        }
      }
      returnPairs.add(bestPair);
      removePair(totalPairs, bestPair);
    }
    return returnPairs;
  }
  
  private static void removePair(List<Pair> pairs, Pair pair) {
    Iterator<Pair> iterator = pairs.iterator();
    while(iterator.hasNext()) {
      Pair nestedPair = iterator.next();
      if (pair.first == nestedPair.first 
          || pair.first == nestedPair.second   
          || pair.second == nestedPair.first 
          || pair.second == nestedPair.second) {
        iterator.remove();
      }
    }
  }

  private static final class Pair {
    public int first;
    public int second;

    /**
     * @param first
     * @param second
     */
    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}