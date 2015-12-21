package Commands;

import drt.Driver;
/**
 * Kills every Cell and Virus in the World.
 * @author Jaime
 *
 */
public class MeteorFall extends Cmd {

	@Override
	public void run(Driver world) {
		world.xRisk();

	}

	@Override
	public Cmd parse(String cmd) {
		if(cmd.equalsIgnoreCase("METEORFALL")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "METEORFALL: Kill every cell and virus";
	}

}
