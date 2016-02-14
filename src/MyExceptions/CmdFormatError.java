package MyExceptions;

/**
 * Exception thrown when the arguments of a command are incorrect.
 * @author Jaime
 *
 */
public class CmdFormatError extends Exception {
	public CmdFormatError(){
		super("The command arguments were incorrect.");
	}
	public CmdFormatError(String message){
		super(message);
	}
}
