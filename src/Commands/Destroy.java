package Commands;

import WorldModel.World;
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
	public void run(World world) {
		world.getSurface().destroy(x, y);
	}

	@Override
	public Cmd parse(String cmd) {
		String[] cmd1 = cmd.split(" ");
		if (cmd1[0].equals("DESTROY")){
			int x,y;
			try{
				x = Integer.parseInt(cmd1[1]);
				y = Integer.parseInt(cmd1[2]);
				return new Destroy(x,y);
			}
			catch (Exception e){ return null;}
			
		}
		return null;
	}

	@Override
	public String help() {
		return "DESTROY x y: Destroy the cell/virus in pos x y";
	}

}
