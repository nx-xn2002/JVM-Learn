package com.nx.learn.jvm.oom;

/**
 * Java 虚拟机栈 StackOverflowError实验一:使用 -Xss 参数减少栈内存容量
 * VM Options:-Xss128k
 *
 * @author Ni Xiang
 */
public class JavaVMStackSOF1 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF1 oom = new JavaVMStackSOF1();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
