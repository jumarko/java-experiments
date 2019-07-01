import sun.jvm.hotspot.oops.InstanceKlass;
import sun.jvm.hotspot.oops.Klass;
import sun.jvm.hotspot.oops.Method;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

/**
 * See https://stackoverflow.com/questions/55698109/has-this-method-ever-been-called-inside-a-running-jvm/55707733#55707733
 * Don't forget to Alt-Enter on "red imports" and add "-add-exports" to compiler options
 * -> Settings -> Java Compiler:
 * <code>
 *    --add-modules=jdk.hotspot.agent \
 *    --add-exports jdk.hotspot.agent/sun.jvm.hotspot=ALL-UNNAMED \
 *    --add-exports=jdk.hotspot.agent/sun.jvm.hotspot.oops=ALL-UNNAMED \
 *    --add-exports=jdk.hotspot.agent/sun.jvm.hotspot.runtime=ALL-UNNAMED \
 *    --add-exports=jdk.hotspot.agent/sun.jvm.hotspot.tools=ALL-UNNAMED
 *    # this one is not added automatically by the IDE!
 *    --add-exports "jdk.hotspot.agent/sun.jvm.hotspot.classfile=ALL-UNNAMED"
 * </code>
 *
 */
public class CheckMethodCall extends Tool {
    private static final String className = "java/util/HashMap";
    private static final String methodName = "get";
    private static final String methodSig = "(Ljava/lang/Object;)Ljava/lang/Object;";

    @Override
    public void run() {
        Klass klass = VM.getVM().getClassLoaderDataGraph().find(className);
        if (klass == null) {
            System.out.println("Class not found");
            return;
        }

        Method method = ((InstanceKlass) klass).findMethod(methodName, methodSig);
        if (method == null) {
            System.out.println("Method not found");
            return;
        }

        boolean called = method.getMethodCounters() != null &&
                method.getInvocationCount() + method.interpreterInvocationCount() > 0;
        System.out.println("Method " + (called ? "has been" : "has NOT been") + " called");
        if (called) {
            System.out.println("called: " + method.getInvocationCount() + method.interpreterInvocationCount() + " times.");
        }
    }

    public static void main(String[] args) {
        new CheckMethodCall().execute(args);
    }
}
