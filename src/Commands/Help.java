package Commands;

import drt.Driver;
/**
 * Prints the help string of each command.
 * @author Jaime
 *
 */
public class Help extends Cmd {

	@Override
	public void run(Driver world) {
		CmdParser.help();
	}

	@Override
	public Cmd parse(String cmd) {
		if (cmd.equalsIgnoreCase("HELP"))	return this;
		else return null;
	}

	@Override
	public String help() {
		return "HELP: Show a list of commands";
	}


}
