package net.curiosprogrammer.javaexperiments;

/**
 * The first time I've found similar example in the Well-grounded Java Developer book.
 * Similar thing also mentioned in the CppCon 2016: Timur Doumler “Want fast C++? Know your hardware!" talk: https://youtu.be/BP6NxVxDQIs?t=1422
 *  - Note: i didn't observed the huge performance degration around step=256 as he mentioned
 */
public class ArraysAndCaches {

    public static void main(String[] args) {
        int[] nums = new int[1000_000_000];

        int step = 128;

        System.out.println("Start test...");
        final long start = System.nanoTime();
        int i = 0;
        for (int repeat = 0; repeat < 10_000; repeat++) {
            nums[i]++;
            i = i + step;
        }
        final long end = System.nanoTime();
        System.out.println("Computed in " + (end - start) + " ns.");

        // sum the up to pretend all pieces are actually used (probably not needed at all)
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        System.out.println("Sum is: " + sum);
    }
}
