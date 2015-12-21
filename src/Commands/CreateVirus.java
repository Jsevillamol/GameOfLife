package Commands;

import WorldModel.World;
/**
 * Creates a Virus in the specified position
 * @author Jaime
 *
 */
public class CreateVirus extends Cmd{
	private int x,y;
	
	CreateVirus(){}
	
	CreateVirus(int ix, int iy){
		x = ix;
		y = iy;
	}
	
	@Override
	public void run(World world) {
		world.getSurface().createVirus(x, y);
	}

	@Override
	public Cmd parse(String cmd) {
		String[] cmd1 = cmd.split(" ");
		if (cmd1[0].equals("CREATEVIRUS")){
			int x,y;
			try{
				x = Integer.parseInt(cmd1[1]);
				y = Integer.parseInt(cmd1[2]);
				return new CreateVirus(x,y);
			}
			catch (Exception e){ return null;}
			
		}
		return null;
	}

	@Override
	public String help() {
		return "CREATEVIRUS x y: Create a virus in pos x y";
	}

}
