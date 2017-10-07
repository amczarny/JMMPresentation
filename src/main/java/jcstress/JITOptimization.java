package jcstress;

import org.openjdk.jcstress.annotations.*;

@JCStressTest(Mode.Termination)
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class JITOptimization {
   int flag;

   @Actor
   public void actor1() {
      while (flag == 0) {
      }
   }

   @Signal
   public void terminate() throws InterruptedException {
      Thread.sleep(1000);
      flag = 1;
   }
}
