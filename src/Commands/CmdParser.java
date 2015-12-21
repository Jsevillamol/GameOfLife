package Commands;
/**
 * Parses a string into its corresponding command
 * @author Jaime
 *
 */
public class CmdParser {
	static Cmd[] cmds = {
			new Step(),
			new Help(),
			new CreateCell(),
			new CreateVirus(),
			new Destroy(),
			new MeteorFall(),
			new Reset(),
			new Exit(),
			new EasterEgg()
		};
	static public String help(){
		for (Cmd cmd:cmds)System.out.println(cmd.help());
		return null;
	}
	static public Cmd parse(String s){
		Cmd match = null;
		for (int i = 0; i < cmds.length && match == null; i++) 
			match = cmds[i].parse(s);
		return match;
	}
}
