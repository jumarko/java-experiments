package net.curiosprogrammer.javaexperiments;

public class RuntimeFreeMemory {

    // when running -Xms8g -Xmx8g
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        System.out.println(r.freeMemory()); // 8581851136
        System.out.println(r.totalMemory()); // 8589934592

        System.out.println("Process PID: " + ProcessHandle.current().pid());
        
        String[] arr = new String[100000000];
        for (int i = 0; i < 100000000; i++)
            arr[i] = new String();

        System.out.println(r.freeMemory()); // 5717141504
        System.out.println(r.totalMemory()); // 8589934592
    }

    // compare results when using ONLY -Xmx8g
    // 537178112
    // 541065216
    // 3240407040
    // 6104809472

}