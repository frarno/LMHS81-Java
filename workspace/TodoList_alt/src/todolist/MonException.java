package todolist;

public class MonException extends Exception {

	protected int id;
	static final long serialVersionUID = 2;
	
	public MonException() {
		
	}

	public MonException(int id, String message) {
		super(message);
		this.id = id;
	}
	
	public void display()
	{
		System.out.println("Erreur de type " + id + " !!!");
		System.out.println("Info : " + getMessage());
	}
		

	
	public MonException(Throwable cause) {
		super(cause);
		
	}

	public MonException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MonException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
