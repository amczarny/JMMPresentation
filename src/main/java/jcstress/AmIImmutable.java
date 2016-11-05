package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult3;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class AmIImmutable {
    int x, y, z;
    static AmIImmutable i = new AmIImmutable();
    public AmIImmutable() {
        x = 1;
        y = 2;
        z = 3;
    }

    @Actor
    public void actor1() {
        i = new AmIImmutable();
    }

    @Actor
    public void actor2(IntResult3 r) {
        r.r1 = i.x;
        r.r2 = i.y;
        r.r3 = i.z;
    }
}
