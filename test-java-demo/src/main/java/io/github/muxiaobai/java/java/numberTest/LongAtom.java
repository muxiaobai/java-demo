package io.github.muxiaobai.java.java.numberTest;


public class LongAtom implements Runnable {

        private static long field = 0;

        private volatile long value;

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public LongAtom(long value) {
            this.setValue(value);
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 100000) {
                LongAtom.field = this.getValue();
                i++;
                long temp = LongAtom.field;
                if (temp != 1L && temp != -1L) {
                    System.out.println("出现错误结果" + temp);
                    System.exit(0);
                }
            }
            System.out.println("运行正确");
        }

    /**
     * 32位虚拟机
     * 32位虚拟机不能保证Long原子性，64位可以
     * Long 8字节 64位，32位需要两条指令。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
            // 获取并打印当前JVM是32位还是64位的
            String arch = System.getProperty("sun.arch.data.model");
            System.out.println(arch+"-bit");
            LongAtom t1 = new LongAtom(1);
            LongAtom t2 = new LongAtom(-1);
            Thread T1 = new Thread(t1);
            Thread T2 = new Thread(t2);
            T1.start();
            T2.start();
            T1.join();
            T2.join();
        }

    }
