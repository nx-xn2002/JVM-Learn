package com.nx.learn.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 堆溢出
 * VM Options:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author Ni Xiang
 */
public class HeapOutOfMemory {
    static class OutOfMemoryObject {
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new OutOfMemoryObject());
        }
    }
}
