package Commands;

import MyExceptions.CmdFormatError;
import Main.Driver;
/**
 * Destroys the Cell/Virus in the specified position
 * @author Jaime
 *
 */
public class Destroy extends Cmd {

	private int x,y;
	
	Destroy(){}
	
	Destroy(int ix, int iy){
		x = ix;
		y = iy;
	}
	
	@Override
	public void run(Driver world) throws CmdFormatError {
		try{
			world.destroy(x, y);
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError("Cell Out of Bounds");
		}
	}

	@Override
	public Cmd parse(String cmd) throws NumberFormatException, CmdFormatError {
		String[] cmd1 = cmd.split(" ");
		if (cmd1[0].equalsIgnoreCase("DESTROY")){
			int x,y;
			x = Integer.parseInt(cmd1[1]);
			y = Integer.parseInt(cmd1[2]);
			return new Destroy(x,y);
		}
		return null;
	}

	@Override
	public String help() {
		return "DESTROY x y: Destroy the cell/virus in pos x y";
	}

}
