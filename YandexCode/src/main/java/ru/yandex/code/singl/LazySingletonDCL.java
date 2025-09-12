package ru.yandex.code.singl;

public class LazySingletonDCL {
    private static volatile LazySingletonDCL instance;

    // Some defence but still can be broken vie reflection because Эта защита сработает только если instance уже создан.
    private LazySingletonDCL() {
        if (instance != null) {
            throw new RuntimeException("Используйте getInstance(), а не Reflection!");
        }
    }
    public static LazySingletonDCL getInstance() {
        if (instance == null) {
            synchronized (LazySingletonDCL.class) {
                if (instance == null) {
                    instance = new LazySingletonDCL();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Работаем!");
    }
}
