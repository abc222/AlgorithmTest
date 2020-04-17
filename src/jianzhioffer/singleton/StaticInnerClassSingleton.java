package jianzhioffer.singleton;

public class StaticInnerClassSingleton {

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton mInstance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.mInstance;
    }

    //private StaticInnerClassSingleton(){}
}
