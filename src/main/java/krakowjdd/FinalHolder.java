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
package krakowjdd;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

import java.io.Serializable;

@JCStressTest
@Outcome(id = "1, 2", expect = Expect.ACCEPTABLE)
@State
public class FinalHolder implements Serializable {
   static Holder holder = new Holder();

   @Actor public void actor1() {
      holder = new Holder();
   }

   @Actor public void actor2(II_Result r) {
      Holder localHolder = holder;
      if (localHolder.instance == null) {
         r.r1 = r.r2 = -100;
      } else {
         r.r1 = localHolder.instance.a;
         r.r2 = localHolder.instance.b;
      }
   }

   private static class Holder{
      final Mutable instance;
      Holder() {
         //assume as effectively immutable - fields of the instance will never be changed after construction
         instance = new Mutable();
      }
   }

   private static class Mutable {
      int a;
      int b;
      Mutable() {
         a = 1;
         b = 2;
      }

   }
}
