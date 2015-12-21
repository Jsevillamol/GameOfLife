package Commands;

import WorldModel.World;
import drt.BrowseURL;
/**
 * ???
 * @author Jaime
 *
 */
public class EasterEgg extends Cmd {

	@Override
	public void run(World world) {
		BrowseURL.EasterEgg();
	}

	@Override
	public Cmd parse(String cmd) {
		if (cmd.equals("EASTEREGG")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "EASTEREGG: ???";
	}

}
