package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult1;
import org.openjdk.jcstress.infra.results.IntResult2;

@JCStressTest
@State
@Description("No data races. Program is correctly synchronized")
@Outcome(id = "[0, 0]", expect = Expect.ACCEPTABLE)
public class OutOfThinAir {
    int x, y;

    @Actor
    public void actor1(IntResult2 r) {
        r.r1 = x;
        if (r.r1 != 0) {
            y = 1;
        }
    }

    @Actor
    public void actor2(IntResult2 r) {
        r.r2 = y;
        if (r.r2 != 0) {
            x = 1;
        }
    }
}
