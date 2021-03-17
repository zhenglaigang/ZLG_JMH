package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T_ParallelStream {
  static List<Integer> list = new ArrayList();
  static Random r = new Random();
  static {
    for (int i = 0; i < 10000; i++) {
      list.add((1000000 + r.nextInt(1000000)));
    }
  }
  static void forEach() {
    long start = System.currentTimeMillis();
    list.stream().forEach(num ->isPrime(num));
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  static void forParallel() {
    long start = System.currentTimeMillis();
    list.parallelStream().forEach(T_ParallelStream::isPrime);
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  private static boolean isPrime(long num) {
    for (int i = 2; i < num/2; i++) {
      if (num%i == 0) {
        return  false;
      }
    }
    return true;
  }
}
