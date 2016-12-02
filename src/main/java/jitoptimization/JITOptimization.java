package jitoptimization;

public class JITOptimization {
    private static boolean flag = true;
    public static void main(String... args) throws InterruptedException {
        new Thread(JITOptimization::loop).start();
        Thread.sleep(1000);
        new Thread(JITOptimization::terminate).start();
    }

    public static void terminate() {
        flag = false;
        System.out.println("Flag has been changed");
    }

    public static void loop() {
        boolean printOnce = true;
        while (getFlag()) {
            if (printOnce) {
                printOnce = false;
                System.out.println("I'm in the loop");
            }
        }
        System.out.println("I'm outside of the loop");
    }

    public static boolean getFlag() {
        return flag;
    }
}