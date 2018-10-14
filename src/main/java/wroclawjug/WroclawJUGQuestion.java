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
package wroclawjug;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.III_Result;

@JCStressTest
@Outcome(id = "1, 2, 3", expect = Expect.ACCEPTABLE)
@Outcome(expect = Expect.FORBIDDEN, desc = "We should not be able to access uninitialized instance variables")
@State
public class WroclawJUGQuestion {
   static WroclawJUGQuestion i = new WroclawJUGQuestion();
   volatile int x;
   volatile int y;
   volatile int z;

   WroclawJUGQuestion() {
      x = 1;
      y = 2;
      z = 3;
   }

   @Actor public void actor1() {
      i = new WroclawJUGQuestion();
   }

   @Actor public void actor2(III_Result r) {
      WroclawJUGQuestion tmp = i;
      r.r1 = tmp.x;
      r.r2 = tmp.y;
      r.r3 = tmp.z;
   }
}
