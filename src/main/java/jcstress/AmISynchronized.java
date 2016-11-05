package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult1;
import org.openjdk.jcstress.infra.results.IntResult2;

import java.util.LinkedHashMap;
import java.util.Map;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class AmISynchronized {
    volatile int x=1;
    int y=1;

    @Actor
    public void actor1() {
        y=2;
        x=3;
    }

    @Actor
    public void actor2(IntResult1 r) {
        r.r1 = y * x;
    }
}


