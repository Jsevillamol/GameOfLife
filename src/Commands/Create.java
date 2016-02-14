package Commands;

import MyExceptions.CmdFormatError;
import Main.Driver;
/**
 * Creates a SimpleCell in the specified position
 * @author Jaime
 *
 */
public class Create extends Cmd{
	private int x,y;
	
	Create(){}
	
	Create(int ix, int iy){
		x = ix;
		y = iy;
	}
	
	@Override
	public void run(Driver world) throws CmdFormatError {
		try{
			if (world.isComplex()){
				String c;
				System.out.println("Create simple cell(s) or virus(v)?");
				c = world.getIn().nextLine().toUpperCase();
				if (c.equalsIgnoreCase("v")) world.createVirus(x,y);
				else if (c.equalsIgnoreCase("s")) world.createCell(x, y);
				else throw new CmdFormatError("You must write \"V\" or \"S\"");
			}
		
			world.createCell(x, y);
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError("Cell OutOfBounds");
		}
	}

	@Override
	public Cmd parse(String cmd) throws CmdFormatError {
		String[] cmd1 = cmd.split(" ");
		try{
		if (cmd1[0].equalsIgnoreCase("CREATE")){
			int x,y;
			x = Integer.parseInt(cmd1[1]);
			y = Integer.parseInt(cmd1[2]);
			return new Create(x,y);
			
		}
		return null;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError();
		}
	}

	@Override
	public String help() {
		return "CREATE x y: Create a cell in pos x y";
	}

}
