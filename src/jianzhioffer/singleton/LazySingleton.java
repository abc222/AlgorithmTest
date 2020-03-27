package jianzhioffer.singleton;

public class LazySingleton {

    private static LazySingleton mInstance;

    // 方法1 线程不安全
    public static LazySingleton getInstance() {
        if (mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }

    // 方法1 加锁
    public synchronized static LazySingleton getInstance2() {
        if (mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }

    // 方法3 双重锁机制
    //private volatile static LazySingleton mInstance;
    public static LazySingleton getInstance3() {
        if (mInstance == null) {
            synchronized (LazySingleton.class) {
                if (mInstance == null) {
                    mInstance = new LazySingleton();
                }
            }
        }
        return mInstance;
    }

    //private LazySingleton();
}
