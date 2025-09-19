package ru.yandex.code.structures;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {

    static class LRUCache<K,V> extends LinkedHashMap<K,V> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true); // true = accessOrder
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > capacity; // удаляем LRU при переполнении
        }
    }


    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1); // "1" стал самым свежим
        cache.put(4, "D"); // удалится "2" (самый старый по использованию)

        System.out.println(cache); // {3=C, 1=A, 4=D}
    }

}
