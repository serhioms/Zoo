package ru.yandex.code.singl;

public enum EnumForceSinglton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Работаем!");
    }
}
