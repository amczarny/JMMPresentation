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

import java.util.function.IntSupplier;

@JCStressTest
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE)
@Outcome(expect = Expect.FORBIDDEN, desc = "We should not be able to access uninitialized final field x")
@State
public class Escape {
   volatile static IntSupplier supplier;
   static Escape escape = new Escape();

   final int x;
   Escape() {
      supplier = () -> getX();
      x = 1;
   }

   int getX() {
      return x;
   }

   @Actor
   public void actor1() {
      escape = new Escape();
   }

   @Actor
   public void actor2(II_Result r) {
      r.r1 = supplier.getAsInt();
      r.r2 = escape.getX();
   }
}
