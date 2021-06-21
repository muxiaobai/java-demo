package io.github.muxiaobai.tool.taskset;


import net.openhft.affinity.AffinityLock;

/**
 * 绑cpu
 */
public class AffinityLockDemo {
    public static void main(String[] args) {
        try (AffinityLock affinityLock = AffinityLock.acquireLock(5)) {
            // do some work while locked to a CPU.
            while(true) {}
        }
    }
}
