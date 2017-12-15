package genericImplementations;

import java.util.*;

public class HashmapCustom <K,V>{
	private int bucketSize;
	Entry<K,V>[] bucket;
	
	public HashmapCustom(int bucketSize){
		this.bucketSize=bucketSize;
		bucket= new Entry[bucketSize];
	}
	public HashmapCustom(){};
	
	public class Entry<K,V>{
		K key;
		V value;
		Entry next;
		
		public Entry(K key,V value){
			this.key=key;
			this.value=value;
			this.next=null;
		}
	}
	
	public void add(K key, V value){
		if(key==null)
			return;
		
		int hashCode=hash(key);
		
		//System.out.println("HashCode:  "+hashCode);
		Entry<K,V> newEntry=new Entry<K,V>(key,value);
		if(bucket[hashCode]==null){
			bucket[hashCode]=newEntry;
		}
		else{
			Entry<K,V> previous = null;
			Entry<K,V> current = null;
			current = bucket[hashCode];
			while(current!=null){
				if(current.key==newEntry.key){
					current=newEntry;
					return;
				}
				previous=current;
				current=current.next;
			}
			previous.next=newEntry;
		}
		
	}
	
	public V get(K key){
		int hash=hash(key);
		//System.out.println("get()  Hash:  "+hash);
		//System.out.println("Bucket [hash]:  "+bucket[hash].value);
		if(bucket[hash]==null){
			//System.out.println("In null");
			return null;
		}
		Entry<K,V> current = bucket[hash];

		while(current !=  null){
			if(current.key==key)
				return current.value;			
			current=current.next;
		}
		return null;
		
	}
	
	
	public boolean remove(K key){
		int hash=hash(key);
		Entry<K,V> current = bucket[hash];
		//System.out.println("Bucket [hash]:  "+bucket[hash].value);
		if(current == null)
			return false;
		Entry<K,V> previous=bucket[hash];
		while(current!= null ){
			if(current.key==key){
				if(current.next!=null){
					System.out.println("In if");
					
					if(current==previous)
						bucket[hash]=current.next;
					
					else
						previous.next=current.next;
					return true;
				}
				else{
					System.out.println("In else");
					System.out.println("previous.key:  "+previous.key);
					if (current==previous)
						bucket[hash]=null;
					else
						previous.next=null;
					return true;
				}
			}
			previous=current;
			current=current.next;
		}
		return false;
	}
	
	public void display(){
		for(int i=0;i<bucketSize;i++){
			if(bucket[i]!=null){
				Entry<K,V> temp=bucket[i];
				while(temp!=null){
					System.out.println("Key:  "+temp.key+"  Value:  "+temp.value);
					temp=temp.next;
				}
			}
		}
		
	}
	
	private int hash(K key){
		//return key.hashCode()%bucketSize; 
        return Math.abs(key.hashCode())% bucketSize;
    }
	
	
	
	public static void main(String [] args){
		HashmapCustom<Integer,Integer> hm=null;
		hm=new HashmapCustom(5);
		hm.add(11,22);
		hm.add(21,32);
		hm.add(23,43);
		hm.add(44,32);
		hm.add(54,21);
		hm.add(65,26);
		hm.add(64,234);
		hm.add(74,232);
		//hm.display();
		//System.out.println("hm.remove(): "+hm.remove(44));
		hm.display();
		//System.out.println("hm.get(Key): "+hm.get(74));
		//System.out.println(hm.get(23));
	}
}
