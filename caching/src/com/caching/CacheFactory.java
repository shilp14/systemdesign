package com.caching;

public class CacheFactory {
	
	private static ICache cacheObj;
	
	private CacheFactory() {
		
		
	}
	public static ICache getCacheObj(CacheType type) {
		
		switch(type) {
		
		case LRU:
			cacheObj=new LRUCache<>();
			break;
			
		case LFU:	
		
		}
		
		return cacheObj;
		
		
	}
	
}
