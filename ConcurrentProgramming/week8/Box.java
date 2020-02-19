public class Box<T>{
	
	//Atributes
	private final T content;
	
	//Contstructor
	public Box(T content){
		this.content = content;
	}

	//Returns the content of this box
	public T contents(){
		return content;
	}
	
	//Implementation of Apply
	public O apply(BoxFunction<T,O> BoxFunctions){
		return BoxFunctions.apply(this.contents);
	}

}