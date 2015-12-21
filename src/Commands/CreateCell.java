package Commands;

import WorldModel.World;
/**
 * Creates a SimpleCell in the specified position
 * @author Jaime
 *
 */
public class CreateCell extends Cmd{
	private int x,y;
	
	CreateCell(){}
	
	CreateCell(int ix, int iy){
		x = ix;
		y = iy;
	}
	
	@Override
	public void run(World world) {
		world.getSurface().createCell(x, y);
	}

	@Override
	public Cmd parse(String cmd) {
		String[] cmd1 = cmd.split(" ");
		if (cmd1[0].equals("CREATECELL")){
			int x,y;
			try{
				x = Integer.parseInt(cmd1[1]);
				y = Integer.parseInt(cmd1[2]);
				return new CreateCell(x,y);
			}
			catch (Exception e){ return null;}
			
		}
		return null;
	}

	@Override
	public String help() {
		return "CREATECELL x y: Create a cell in pos x y";
	}

}
