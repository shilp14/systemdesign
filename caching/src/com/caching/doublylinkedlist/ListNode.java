package com.caching.doublylinkedlist;

public class ListNode<K,V> implements IListNode<K, V>{
	
	private Entry<K,V> start;
	private Entry<K,V> end;
	
	
	@Override
	public boolean addAtFront(Entry<K, V> entry) {
		entry.next=start;
		if(start!=null) {
			start.prev=entry;
		}
		start=entry;
		if(end==null) {
			end=start;
		}
		return true;
	}

	@Override
	public boolean addAtEnd(Entry<K, V> entry) {
		end.next=entry;
		entry.prev=end;
		end=entry;
		return true;
	}

	@Override
	public boolean removeNode(Entry<K, V> entry) {
      if(entry.prev!=null) {
    	  entry.prev.next=entry.next;
      }
      else {
    	  start=entry.next;
      }
    	 
      if(entry.next!=null) {
    	entry.next.prev=entry.prev;  
      }
      else {
    	  end=end.prev;
      }
		return true;
	}
	
	public Entry<K,V> getEndNode(){
		return end;
	}
	
}
