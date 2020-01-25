public class Safes{

	private String secret;
	private boolean locked;
	private int[] password;
	private int howFar;
	
	
	/*
	 * Constructor for safes
	 */
	public Safes(int[] password){
		this.password = new int[password.length];
		for(int i = 0; i<password.length;i++)
			this.password[i] = password[i];
		this.secret = null;
		locked = false;
		howFar = password.length+1;
	}
	
	/*
	 * Returns the boolean locked
	 */
	public boolean locked(){
		return locked;
	}
	
	/*
	 * Stores a string as the secret in an unlocked safe
	 */
	public void store(String secret){
		if (!locked)
			this.secret = secret;
	}
	
	/*
	 * Returns the secret if the safe is unlocked
	 */
	public String contents(){
		if (!locked)
			return secret;
		else
			return null;
	}
	
	/*
	 * Insert a number into the combination lock.
	 */
	public void insert(int n){
		if (howFar>=password.length)
			reset();
		if(n==password[howFar])
			howFar = howFar + 1;
		else{
			reset();
			if (n == password[howFar])
				howFar = howFar + 1;
		}
		locked = howFar<password.length;
	}
	
	/*
	 * Resets the combination lock and locks the safe
	 */
	public void reset(){
		howFar=0;
		locked = howFar<password.length;
	}

}