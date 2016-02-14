package MyExceptions;

/**
 * Exception thrown when the number of cells to be initialized is greater than the size of the Surface.
 * @author Jaime
 *
 */
public class InitError extends Exception {
	public InitError(){
		super();
	}
	
	public InitError(String msg){
		super(msg);
	}
}
