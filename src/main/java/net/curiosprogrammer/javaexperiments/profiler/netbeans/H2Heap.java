package net.curiosprogrammer.javaexperiments.profiler.netbeans;

import org.netbeans.lib.profiler.heap.Heap;
import org.netbeans.lib.profiler.heap.HeapFactory;
import org.netbeans.lib.profiler.heap.Instance;
import org.netbeans.lib.profiler.heap.JavaClass;

import java.io.File;
import java.io.IOException;

public class H2Heap {

    private static void analyzeHeap(File heapDump) {
        try {
            Heap heap = HeapFactory.createHeap(heapDump);
            final JavaClass fileLockTableClass = heap.getJavaClassByName("sun.nio.ch.FileLockTable");
            for (Object instance : fileLockTableClass.getInstances()) {
                System.out.println(( (Instance) instance).getFieldValues());
                
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot analyze heap dump from  " +heapDump, e);
        }
    }

    public static void main(String[] args) {
        analyzeHeap(new File("/Users/jumar/Work/Empear-Codescene/support-issues/SystemVerification/tobias-internal-server-error/heapdump.2019-10-07_08-44-30.hprof"));
    }
}
