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
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@Outcome(expect = Expect.ACCEPTABLE)
@State
public class StringWroclawJUGQuestion2 {
   static StringWroclawJUGQuestion2 i = new StringWroclawJUGQuestion2();
   final char [] value = new char[]{'J', 'M', 'M'};
   int hash = 0;

   @Actor public void actor1() {
      i = new StringWroclawJUGQuestion2();
   }

   @Actor public void actor2(II_Result r) {
      r.r1 = i.hashCode();
   }

   @Actor public void actor3(II_Result r) {
      r.r2 = i.hashCode();
   }

   public int hashCode() {
      int h = hash;
      if (h == 0 && value.length > 0) {
         char val[] = value;

         for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
         }
         hash = h;
      }
      return h;
   }
}
