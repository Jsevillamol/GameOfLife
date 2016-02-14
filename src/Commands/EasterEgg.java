package Commands;

import Main.BrowseURL;
import Main.Driver;
/**
 * ???
 * @author Jaime
 *
 */
public class EasterEgg extends Cmd {

	@Override
	public void run(Driver world) {
		BrowseURL.EasterEgg();
	}

	@Override
	public Cmd parse(String cmd) {
		if (cmd.equalsIgnoreCase("EASTEREGG")) return this;
		else return null;
	}

	@Override
	public String help() {
		return "EASTEREGG: ???";
	}

}
