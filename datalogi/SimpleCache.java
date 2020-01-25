public class SimpleCache<K,E>{

	private int newestIndex;
	private E[] elem;
	private K[] keys;
	private int howMany;
	
	//Constructor
	public SimpleCache(int capacity){
		newestIndex = -1;
		elem = (E[]) new Object[capacity];
		keys = (K[]) new Object[capacity];
		howMany = 0;
	}

	/*
	 * Returns an array of all the keys in this cache
	 */
	public K[] keys(){
		K[] output = (K[]) new Object[howMany];
		int j = 0;
		for (int i = 0; keys.length > i; i++)
			if (keys[i] != null){
				output[j] = keys[i];
				j = j + 1;
			}
		return output;
	}
	
	/*
	 * Returns an array of all the elements in this Cache
	 */
	public E[] values(){
		E[] output = (E[]) new Object[howMany];
		int j = 0;
		for (int i = 0; i < elem.length; i++)
			if (elem[i] != null){
				output[j] = elem[i];
				j = j + 1;
			}
		return output;
	}
	
	/*
	 * Returns the size of this cache
	 */
	public int size(){
		return howMany;                   
	}
	
	/*
	 * Adds an element to this cache
	 */
	public void add(K key, E e){
		remove(key);
		newestIndex = (newestIndex+1)%keys.length;
		if(keys[newestIndex] == null)
			howMany = howMany + 1;
		keys[newestIndex] = key;
		elem[newestIndex] = e;
	}
	
	/*
	 * Removes an element from this cache with key
	 */
	public void remove(K key){
		for(int i = 0; i<keys.length;i++)
			if (keys[i] != null && keys[i].equals(key)){
					keys[i] = null;
					elem[i] = null;
					howMany = howMany - 1;
				}
	}

	/*
	 * Finds and returns the element with the key in this cache
	 */
	public E find(K key){
		E output= null;
		
		int i = 0;
		while (i<keys.length && output == null){
			if(keys[i] != null && keys[i].equals(key))
				output = elem[i];
			i = i + 1;
		}
		return output;
	}
	
	/*
	 * Returns a boolean stating if this cache is empty
	 */
	public boolean isEmpty(){
		return (howMany==0);
	}
	
	/*
	 * Clears this cache
	 */
	public void clear(){
		for(int i = 0; i < keys.length; i++){
			keys[i] = null;
			elem[i] = null;
		}
		howMany = 0;
		newestIndex = -1;
	}
	
	
	//Mangler iterator
}