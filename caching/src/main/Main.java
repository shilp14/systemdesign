package main;

import com.caching.CacheFactory;
import com.caching.CacheType;
import com.caching.ICache;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ICache<String,String> cacheObj= CacheFactory.getCacheObj(CacheType.LRU);
		cacheObj.put("key1", "valu1");
		cacheObj.put("key2", "valu2");
		cacheObj.put("key3", "valu3");
		cacheObj.put("key1", "valu2");
		cacheObj.put("key4", "valu4");
		cacheObj.put("key5", "valu5");
		cacheObj.put("key6", "valu4");
		cacheObj.evict("key5");
		cacheObj.print();
		
	}

}
