package Commands;

import MyExceptions.CmdFormatError;
import MyExceptions.InitError;
import WorldModel.ComplexWorld;
import drt.Driver;
/**
 * Creates a new simulation with both Cells and Virus.
 * @author Jaime
 *
 */
public class PlayComplex extends Cmd {
	private int rows, cols, cells, virus;
	public PlayComplex(int irows, int icols, int icells, int ivirus){
		rows = irows; cols = icols; cells = icells; virus = ivirus;
	}
	public PlayComplex() {}
	@Override
	public void run(Driver driver) throws InitError {
		driver.setWorld(new ComplexWorld(rows, cols, cells, virus));

	}

	@Override
	public Cmd parse(String cmd) throws NumberFormatException, CmdFormatError {
		String[] cmd1 = cmd.split(" ");
		try{
			if (cmd1[0].equalsIgnoreCase("PLAYCOMPLEX")){
				int x,y,c,v;
				x = Integer.parseInt(cmd1[1]);
				y = Integer.parseInt(cmd1[2]);
				c = Integer.parseInt(cmd1[3]);
				v = Integer.parseInt(cmd1[4]);
				return new PlayComplex(x,y,c,v);
			}
			return null;
		} catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError();
		}
	}

	@Override
	public String help() {
		return "PLAYCOMPLEX X Y C: Creates a new Complex World with X rows, Y cols, C cells and V virus";
	}

}
