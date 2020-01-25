public interface MyCollection<E>{

	//Adds given element to the collection
	public void add(E e);
	
	//Clears the collection
	public void clear();
	
	//Checks if element e is in the collection
	public boolean contains(E e);
	
	//Checks if the collection is empty
	public boolean isEmpty();
	
	//Returns the size of the collection
	public int size();

}