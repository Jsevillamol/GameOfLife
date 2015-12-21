package Commands;
import MyExceptions.CmdFormatError;
import MyExceptions.CmdNotFound;
/**
 * Parses a string into its corresponding command
 * @author Jaime
 *
 */
public class CmdParser {
	static Cmd[] cmds = {
			new Step(),
			new Help(),
			new Create(),
			new Destroy(),
			new MeteorFall(),
			new Exit(),
			new PlaySimple(),
			new PlayComplex(),
			new Save(),
			new Load(),
			new EasterEgg()
		};
	static public String help(){
		for (Cmd cmd:cmds)System.out.println(cmd.help());
		return null;
	}
	static public Cmd parse(String s) throws CmdNotFound, CmdFormatError{
		Cmd match = null;
		for (int i = 0; i < cmds.length && match == null; i++) 
			match = cmds[i].parse(s);
		if (match == null) throw new CmdNotFound("No matching command found.");
		return match;
	}
}
