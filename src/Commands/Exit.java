package Commands;

import drt.Driver;
/**
 * Exits the program
 * @author Jaime
 *
 */
public class Exit extends Cmd {

	@Override
	public void run(Driver world) {
		world.stop();
	}

	@Override
	public Cmd parse(String cmd) {
		if(cmd.equalsIgnoreCase("EXIT")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "EXIT: Stop the simulation";
	}

}
