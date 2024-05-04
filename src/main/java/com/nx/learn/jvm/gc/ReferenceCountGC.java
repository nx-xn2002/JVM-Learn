package com.nx.learn.jvm.gc;

/**
 * reference count gc
 * -Xlog:gc*
 *
 * @author Ni Xiang
 */
public class ReferenceCountGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 占用一点内存，以便在 GC 日志中看清楚是否有进行回收
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountGC objA = new ReferenceCountGC();
        ReferenceCountGC objB = new ReferenceCountGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设此处发生GC，objA 和 objB 是否能被回收？
        System.gc();
    }
}
