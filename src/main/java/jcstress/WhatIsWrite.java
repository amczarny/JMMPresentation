package jcstress;


import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult1;
import org.openjdk.jcstress.infra.results.IntResult2;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@Outcome(id="[0, 10]", expect = Expect.FORBIDDEN)
@State
public class WhatIsWrite {
     volatile int i;

    @Actor
    public synchronized void actor1() {
        i++;
    }
    @Actor
    public synchronized void actor2() {
        i++;
    }

    @Arbiter
    public void actor3(IntResult1 r) {
        r.r1=i;
    }
}


