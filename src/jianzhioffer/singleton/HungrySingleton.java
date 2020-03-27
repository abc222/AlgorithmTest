package jianzhioffer.singleton;

// 饿汉模式 线程安全
public class HungrySingleton {

    // 方法1，属性实例
    private static final HungrySingleton mInstance = new HungrySingleton();

    // 方法2 静态代码块实例
//    private static HungrySingleton mInstance;
//
//    static {
//        mInstance = new HungrySingleton();
//    }

    public static HungrySingleton getInstance() {
        return mInstance;
    }

    //private HungrySingleton();
}
