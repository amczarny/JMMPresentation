package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class Escape {
    final int x;
    volatile static Data y;
    volatile static Escape i = new Escape();
    public Escape() {
        y = new Data();
        x = 1;
    }
    private class Data {
        public int getX(){
            return x;
        }
    }

    @Actor
    public void actor1() {
        i = new Escape();
    }

    @Actor
    public void actor2(IntResult2 r) {
        r.r1 = y.getX();
        r.r2 = i.x;
    }
}
