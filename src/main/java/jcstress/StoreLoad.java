/**
 * The MIT License
 * Copyright © 2017 amczarny
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Both actors have finished in the same time")
@Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "First Actor has finished before second")
@Outcome(id = "1, 0", expect = Expect.ACCEPTABLE, desc = "Second Actor has finished before first")
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Intel can reorder Stores with Load")
public class StoreLoad {
   private int x, y;

   @Actor
   public void actor1(II_Result r) {
      x = 1; //store
      r.r1 = y; //load
   }

   @Actor
   public void actor2(II_Result r) {
      y = 1; //store
      r.r2 = x; // load
   }
}
