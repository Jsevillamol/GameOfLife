package Commands;

import WorldModel.World;
/**
 * Resets the simulation.
 * @author Jaime
 *
 */
public class Reset extends Cmd {

	@Override
	public void run(World world) {
		world.reset();
	}

	@Override
	public Cmd parse(String cmd) {
		if(cmd.equals("RESET")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "RESET: Start again the simulation";
	}

}
