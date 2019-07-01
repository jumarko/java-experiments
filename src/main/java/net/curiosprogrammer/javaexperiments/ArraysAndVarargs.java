package net.curiosprogrammer.javaexperiments;

/**
 * You can't have both!
 */
public class ArraysAndVarargs {

    public static int ex1(String... strings) {
        return strings.length;
    }

    /** The following will yield a compilation error **/
//    public static int ex1(String[] strings) {
//        return strings.length;
//    }
    
}
