package jianzhioffer.singleton;

public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> tlSingleton =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance() {
        return tlSingleton.get();
    }

    //private ThreadLocalSingleton() {}
}
