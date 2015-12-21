package Commands;
import WorldModel.World;
/**
 * This class implements commands to be used from the console and that affect the World.
 * @author Jaime
 *
 */
public abstract class Cmd {
	/**
	 * Executes the command.
	 * @param world
	 */
	public abstract void run(World world);
	/**
	 * Identifies if the string is a valid form of the command.
	 * @param cmd
	 * @return
	 */
	public abstract Cmd parse(String cmd);
	/**
	 * Returns a string containing a description of the command.
	 * @return
	 */
	public abstract String help();
}
