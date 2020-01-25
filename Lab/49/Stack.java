import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;
public class Stack<E> implements MyCollection<E>, Iterable<E>{

	private E[] stack;
	private int howManyInStack;
	
	//Constructor der laver en tom stack
	public Stack(){
		stack = (E[]) new Object[10];
		howManyInStack = 0;
	}
	
	//Returnere den øverste fra denne Stack, @precondition: Stack er ikke tom
	public E top(){
		return stack[howManyInStack-1];
	}
	
	//Fjerner den øverste fra denne Stack, @precondition: Stack er ikke tom
	public void pop(){
		howManyInStack = howManyInStack-1;
	}
	
	//Gør stack arrayet større
	private void addSize(){
		E[] newStack = (E[]) new Object[stack.length*2];
		for(int i = 0; i<stack.length;i++)
			newStack[i] = stack[i];
	}
	
	/*
	 * Metoder fra MyCollection
	 */
	//Returnere størrelsen på denne Stack
	public int size(){
		return howManyInStack;
	}
	
	//Returnere en boolean der fortæller om denne Stack er tom
	public boolean isEmpty(){
		return howManyInStack<=0;
	}
	
	//Returenere en boolean der fortæller om denne Stack har element e
	public boolean contains(E e){
		boolean contains = false;
		for(E s: stack)
			if (s.equals(e))
				contains = true;
		return contains;
	}
	
	//Fjerner alle elemtenter fra array
	public void clear(){
		howManyInStack = 0;
	}
	
	//Sætter et nyt element ind i denne stack
	public void add(E e){
		if (howManyInStack!=stack.length){
			stack[howManyInStack] = e;
			howManyInStack = howManyInStack + 1;
		}
		else{
			addSize();
			add(e);
		}
	}
	
	public Iterator<E> iterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<E>{
		
		private int current;
		
		//Constructor for StackIterator
		private StackIterator(){
			current = howManyInStack;
		}
		
		public E next(){
			if (!hasNext())
				throw new NoSuchElementException();
			else{
				current = current-1;
				return stack[current];
			}
		}
		
		//Returnere om der er flere elementer i Stack
		public boolean hasNext(){
			return (current>=3);
		}
	}
}