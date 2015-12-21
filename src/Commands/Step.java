package Commands;

import WorldModel.World;
/**
 * Executes one step of the simulation.
 * @author Jaime
 *
 */
public class Step extends Cmd {

	@Override
	public void run(World world) {
		world.step();
	}

	@Override
	public Cmd parse(String cmd) {
		if(cmd.equals("STEP")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "STEP: Run a step of the simulation";
	}

}
