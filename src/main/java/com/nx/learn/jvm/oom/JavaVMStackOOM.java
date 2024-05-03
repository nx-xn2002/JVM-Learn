package com.nx.learn.jvm.oom;

/**
 * Java 虚拟机栈 OutOfMemory - 创建线程导致的内存溢出异常
 * VM Options:-Xss2M
 *
 * @author Ni Xiang
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
