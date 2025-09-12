package ru.yandex.code.structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ArrayDemo {

    static public void main(String[] args) throws InterruptedException {
        var dynArr = new ArrayList<String>();
        dynArr.ensureCapacity(12);

        var lstArr = new LinkedList<String>();
        lstArr.add("A");
        lstArr.add("B");
        lstArr.add("C");
        Spliterator<String> splt = lstArr.spliterator();
        System.out.println("Первый:");
        splt.tryAdvance(System.out::println);
        System.out.println(splt.estimateSize());
        System.out.println(splt.characteristics());
        System.out.println("Остаток:");
        splt.forEachRemaining(System.out::println);

        Stream<String> s = StreamSupport.stream(lstArr.spliterator(), false);


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        Spliterator<Integer> spl1 = list.spliterator();

        // Пытаемся разделить
        Spliterator<Integer> spl2 = spl1.trySplit();

        // spl1 обрабатывает "первую часть"
        System.out.println("Первый Spliterator:");
        spl1.forEachRemaining(System.out::println);

        // spl2 обрабатывает "вторую часть"
        System.out.println("Второй Spliterator:");
        spl2.forEachRemaining(System.out::println);
    }
}
