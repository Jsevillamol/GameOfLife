package Commands;

import drt.Driver;
/**
 * Executes one step of the simulation.
 * @author Jaime
 *
 */
public class Step extends Cmd {

	@Override
	public void run(Driver world) {
		world.step();
	}

	@Override
	public Cmd parse(String cmd) {
		if(cmd.equalsIgnoreCase("STEP")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "STEP: Run a step of the simulation";
	}

}
