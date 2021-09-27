package com.caching.doublylinkedlist;

public interface IListNode<K,V>{
	
boolean addAtFront(Entry<K,V> entry);
boolean addAtEnd(Entry<K,V> entry);
boolean removeNode(Entry<K,V> entry);
Entry<K,V> getEndNode();
	
}
