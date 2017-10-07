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
package jitoptimization;

public class JITOptimization {
   private static boolean flag = true;

   public static void main(String... args) throws InterruptedException {
      new Thread(JITOptimization::loop).start();
      Thread.sleep(1000);
      new Thread(JITOptimization::terminate).start();
   }

   private static void terminate() {
      flag = false;
      System.out.println("Flag has been changed");
   }

   private static void loop() {
      boolean printOnce = true;
      while (getFlag()) {
         if (printOnce) {
            printOnce = false;
            System.out.println("I'm in the loop");
         }
      }
      System.out.println("I'm outside of the loop");
   }

   private static boolean getFlag() {
      return flag;
   }
}