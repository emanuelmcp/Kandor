package io.github.emanuelmcp.minecraftcore.api;

public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean contains(K key);
}
