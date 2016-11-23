package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;

@JCStressTest
@State
@Outcome(id = "[1, 1]", expect = Expect.ACCEPTABLE, desc = "Both actors have finished in the same time")
@Outcome(id = "[0, 1]", expect = Expect.ACCEPTABLE, desc = "First Actor have finished before second")
@Outcome(id = "[1, 0]", expect = Expect.ACCEPTABLE, desc = "Second Actors have finished before first")
@Outcome(id = "[0, 0]", expect = Expect.ACCEPTABLE_SPEC, desc = "Intel can reorder Stores with Load")
public class StoreLoad {
    int x, y, r1, r2;

    @Actor
    public void actor1() {
        x = 1; //store
        r1 = y; //load
    }

    @Actor
    public void actor2() {
        y = 1; //store
        r2 = x; // load
    }

    @Arbiter
    public void arbiter(IntResult2 r) {
        r.r1 = r1;
        r.r2 = r2;
    }
}
