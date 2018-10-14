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
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = "1", expect = Expect.ACCEPTABLE, desc = "Actor2 is executed before Actor1")
@Outcome(id = "2", expect = Expect.ACCEPTABLE, desc = "Actor2 is executed after y = 2 and before x = 3 in Actor1")
@Outcome(id = "3", expect = Expect.FORBIDDEN, desc = "y = 2 can not be reordered with x = 3 as we have volatile on x")
@Outcome(id = "6", expect = Expect.ACCEPTABLE, desc = "Actor2 executed after Actor1")
@State
public class AmISynchronized {
   int y = 1;
   volatile int x = 1;

   @Actor
   public void actor1() {
      y = 2;
      x = 3;
   }

   @Actor
   public void actor2(I_Result r) {
      r.r1 = y * x;
   }
}


