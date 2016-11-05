package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult1;
import org.openjdk.jcstress.infra.results.IntResult2;
import org.openjdk.jcstress.infra.results.IntResult3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class CrazyCounter {
    int x;

    @Actor
    public void actor1() {
        for (int i = 0; i < 10; i++) {
            x++;
        }
    }

    @Actor
    public void actor2() {
        for (int i = 0; i < 10; i++) {
            x++;
        }
    }

    @Arbiter
    public void arbiter(IntResult1 r) {
        r.r1 = x;
    }
}
