package jianzhioffer.singleton;

import java.util.concurrent.atomic.AtomicReference;

public class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    /**
     * 用CAS确保线程安全
     */
    public static CASSingleton getInstance() {
        while (true) {
            CASSingleton current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new CASSingleton();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }

    //private Singleton() {}
}
