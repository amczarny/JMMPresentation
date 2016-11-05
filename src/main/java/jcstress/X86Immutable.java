package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult1;
import org.openjdk.jcstress.infra.results.IntResult2;
import org.openjdk.jcstress.infra.results.LongResult1;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class X86Immutable {
    int i = 1;
    Data data = new Data(i);

    static class Data {
        final int x;
        int y;
        public Data(int i) {
            x = i;
            y = x + 1;
        }
    }

    @Actor
    public void actor1() {
        data = new Data(i);
    }

    @Actor
    public void actor2(IntResult2 r) {
        r.r1 = data.x;
        r.r2 = data.y;
    }
}
