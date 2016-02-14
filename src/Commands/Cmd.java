package Commands;
import Main.Driver;
import java.io.IOException;

import MyExceptions.CmdFormatError;
import MyExceptions.InitError;
import MyExceptions.SaveFileFormatError;
/**
 * This class implements commands to be used from the console and that affect the World.
 * @author Jaime
 *
 */
public abstract class Cmd {
	/**
	 * Executes the command.
	 * @param world
	 * @throws IOException 
	 * @throws SaveFileFormatError 
	 * @throws CmdFormatError 
	 * @throws InitError 
	 */
	public abstract void run(Driver world) throws IOException, SaveFileFormatError, CmdFormatError, InitError;
	/**
	 * Identifies if the string is a valid form of the command.
	 * @param cmd
	 * @return
	 * @throws CmdFormatError 
	 */
	public abstract Cmd parse(String cmd) throws CmdFormatError;
	/**
	 * Returns a string containing a description of the command.
	 * @return
	 */
	public abstract String help();
}
