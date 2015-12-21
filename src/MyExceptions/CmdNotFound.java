package MyExceptions;
/**
 * Exception thrown when the command input does not match any of the implemented commands.
 * @author Jaime
 *
 */
public class CmdNotFound extends Exception {
	public CmdNotFound(String name){
		super(name);
	}
}
