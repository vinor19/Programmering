public class CounterClient{

	public static void main(String[] args){
	
		Counter counter = new Counter();
		Thread t1 = new Thread( () -> {
			int i = 0;
			while( i < 10 ){
				counter.increment();
				i++;
			}
		});
		Thread t2 = new Thread( () -> {
			int i = 0;
			while( i < 100 ){
				counter.increment();
				i++;
			}
		});
		
		Thread t3 = new Thread( () -> {
			int i = 0;
			while( i < 5 ){
				counter.decrement();
				i++;
			}
		});
		Thread t4 = new Thread( () -> {
			int i = 0;
			while( i < 58 ){
				counter.decrement();
				i++;
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			// t2 finishes here?
			// t1 finishes here?
			// t2 finishes here?
			t1.join();
			// t1 has surely finished here :)
			// t2 finishes here?
			t2.join();
			t3.join();
			t4.join();
			// t2 has surely finished here
			System.out.println( counter.getI() );
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
