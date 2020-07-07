package net.curiosprogrammer.javaexperiments;

public class OtherClass {

    private static void helper() {
        String ahoj = null;
        ahoj.length();
    }


    static {
        helper();
    }

    public static void hello() {
        System.out.println("hello");
    }
}
