package com.caching.doublylinkedlist;

public class Entry<K,V> {

     K key;
	 V value;
	 Entry<K,V> next;
	 Entry<K,V> prev;
	
	public Entry(K key, V value) {
		this.key=key;
		this.value=value;
		this.next=null;
		this.prev=null;
	}
	
	public K getKey() {
		return key;
		
	}
	
	public V getValue() {
		return value;
		
	}
	
}
