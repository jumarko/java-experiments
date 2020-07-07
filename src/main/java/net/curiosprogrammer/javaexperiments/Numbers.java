package net.curiosprogrammer.javaexperiments;

public class Numbers {

    // Note that this method will be called when you comment out the second method with int arg
    private static void overloadNumber(long i) {
        System.out.println("Given long" + i);
    }

//    private static void overloadNumber(int i) {
//        System.out.println("Given int: " + i);
//    }

    public static void main(String[] args) {
        overloadNumber(1);
        System.out.println(Long.MIN_VALUE - 1);
    }
}
