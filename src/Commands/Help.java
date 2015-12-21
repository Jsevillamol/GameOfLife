package Commands;

import WorldModel.World;
/**
 * Prints the help string of each command.
 * @author Jaime
 *
 */
public class Help extends Cmd {

	@Override
	public void run(World world) {
		CmdParser.help();
	}

	@Override
	public Cmd parse(String cmd) {
		if (cmd.equals("HELP"))	return this;
		else return null;
	}

	@Override
	public String help() {
		return "HELP: Show a list of commands";
	}


}
