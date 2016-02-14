package MyExceptions;
/**
 * Exception thrown when the saveFile to be loaded is not correctly formatted.
 * @author Jaime
 *
 */
public class SaveFileFormatError extends Exception {
	public SaveFileFormatError(){
		super();
	}
	public SaveFileFormatError(String msg){
		super(msg);
	}
}
