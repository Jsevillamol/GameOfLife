package Commands;

import MyExceptions.CmdFormatError;
import MyExceptions.InitError;
import WorldModel.SimpleWorld;
import drt.Driver;
/**
 * Creates a new simulation with only SimpleCells.
 * @author Jaime
 *
 */
public class PlaySimple extends Cmd {
	private int rows, cols, cells;
	public PlaySimple(int irows, int icols, int icells){
		rows = irows; cols = icols; cells = icells;
	}
	public PlaySimple() {}
	@Override
	public void run(Driver driver) throws InitError {
		driver.setWorld(new SimpleWorld(rows, cols, cells));

	}

	@Override
	public Cmd parse(String cmd) throws CmdFormatError {
		String[] cmd1 = cmd.split(" ");
		try{
			if (cmd1[0].equalsIgnoreCase("PLAYSIMPLE")){
				int x,y,c;
				x = Integer.parseInt(cmd1[1]);
				y = Integer.parseInt(cmd1[2]);
				c = Integer.parseInt(cmd1[3]);
				return new PlaySimple(x,y,c);
			}
			return null;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError();
		}
	}

	@Override
	public String help() {
		return "PLAYSIMPLE X Y C: Creates a new Simple World with X rows, Y cols and C cells";
	}

}
