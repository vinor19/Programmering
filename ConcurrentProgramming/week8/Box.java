import java.lang.IllegalArgumentException;
public class Box<T>{

	//Atributes
	private final T content;
	
	//Contstructor
	public Box(T content) throws IllegalArgumentException{
		if (content == null)
			throw new IllegalArgumentException();
		this.content = content;
	}

	//Returns the content of this box
	public T contents(){
		return content;
	}
	
	//Implementation of Apply
	public <O> O apply(BoxFunctions<T,O> BoxFunctions){
		return BoxFunctions.apply(this.content);
	}

}