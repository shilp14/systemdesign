package com.caching;

import java.util.HashMap;
import java.util.Map;

import com.caching.doublylinkedlist.Entry;
import com.caching.doublylinkedlist.IListNode;
import com.caching.doublylinkedlist.ListNode;

public class LRUCache<K,V> implements ICache<K,V> {
int capacity;
int size;
HashMap<K,Entry<K,V>> cache;
IListNode<K,V> listObj;
public LRUCache() {
	cache=new HashMap<>();
	listObj=new ListNode<>();
	this.capacity=3;
}

	@Override
	public boolean put(K key, V value) {
		Entry<K, V> entry=new Entry<>(key, value);
		if(size>capacity) {
			cache.remove(listObj.getEndNode().getKey());
			listObj.removeNode(listObj.getEndNode());
			
		}
		if(!cache.containsKey(key)) {
			listObj.addAtFront(entry);
			size++;
		}
		else {
			Entry<K,V> cachevalue=cache.get(key);
			 listObj.removeNode(cachevalue);
			 listObj.addAtFront(entry);
			 
		}
		cache.put(key, entry);
		return true;
	}

	@Override
	public V get(K key) {
		Entry<K,V> cachevalue=null;
		if(cache.containsKey(key)) {
			 cachevalue=cache.get(key);	
			 listObj.removeNode(cachevalue);
			 listObj.addAtFront(cachevalue);
			 return cachevalue.getValue();
		}
		
		return null;
	}

	@Override
	public V evict(K key) {
		Entry<K,V> cachevalue=null;
		V value=null;
		if(!cache.isEmpty()&&cache.containsKey(key)) {
			cachevalue=cache.get(key);
			value=cachevalue.getValue();
			cache.remove(cachevalue.getKey());
			listObj.removeNode(cachevalue);
		}
		
		return value;
	}


	@Override
	public void print() {
	   for(Map.Entry<K,Entry<K, V>> map:cache.entrySet()) {
		   System.out.println("{"+map.getKey()+"="+map.getValue().getValue()+"}");
		    
	   }
		
	}

}
