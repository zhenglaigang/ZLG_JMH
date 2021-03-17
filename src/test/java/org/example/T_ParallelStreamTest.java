package org.example;

import org.openjdk.jmh.annotations.*;

public class T_ParallelStreamTest {
  @Benchmark
  @Warmup(iterations = 1, time = 3)//jvm预热 执行一次，等待3s
  @Fork(5)
  @BenchmarkMode(Mode.Throughput)//吞吐量
  @Measurement(iterations = 1, time = 3)//一共执行多少次，等待多少秒
  public void test() {
    T_ParallelStream.forParallel();
  }
}
