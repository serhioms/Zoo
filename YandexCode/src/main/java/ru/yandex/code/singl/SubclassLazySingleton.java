package ru.yandex.code.singl;

public class SubclassLazySingleton {
    private SubclassLazySingleton() {} // Can be broken vie reflection

    private static class Holder {
        private static final SubclassLazySingleton INSTANCE = new SubclassLazySingleton();
    }

    public static SubclassLazySingleton getInstance() {
        return Holder.INSTANCE;
    }

    /*
    синглтоном является внешний класс, а статический вложенный класс Holder — лишь «тайник» для единственного экземпляра.
    Все методы вы реализуете во внешнем классе-синглтоне и получаете доступ через getInstance().
     */

    public void doSomething() {
        System.out.println("Работаем!");
    }
}
