package com.caching;

public interface ICache<K,V> {

	boolean put(K key, V value);
	V get(K key);
	V evict(K key);
	void print();
		
}
