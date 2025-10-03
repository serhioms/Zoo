package ru.yandex.code.singleton;

public enum EnumForceSinglton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Работаем!");
    }
}
