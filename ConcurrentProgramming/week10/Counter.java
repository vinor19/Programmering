public class Counter{

	private int i;
	
	public Counter(){
		this.i = i;
	}
	
	public int getI(){
		synchronized(this){
			return i;
		}
	}
	
	public void increment(){
		synchronized(this){
			this.i++;
			}
	}

	public void decrement(){
	synchronized(this){
		this.i--;
		}
	}

}