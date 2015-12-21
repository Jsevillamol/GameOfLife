package WorldModel;

import java.util.Random;
/**
 * Special Cells, that eat Simple Cells.
 * @author Jaime
 *
 */
public class Virus extends Cell{

	private static final int DIE_STEPS = 3;
	private int eatenCells;
	
	public boolean isReadyToDie(){
		return eatenCells >= DIE_STEPS;
	}
	
	@Override
	public void print(){
		System.out.printf(" * ");
	}
	
	@Override
	public Pair move(int x, int y, Surface surface) {
		System.out.printf("I am a Virus in %d-%d!", x, y);
		int rx, ry;
		Random randomGenerator = new Random();
		do{
			rx = Math.min(Math.max(0,x + randomGenerator.nextInt(3) - 1), surface.getRows()-1);
			ry = Math.min(Math.max(0,y + randomGenerator.nextInt(3) - 1), surface.getCols()-1);
		}while(rx==x && ry==y);
		System.out.printf("I'll move to %d-%d!\n", rx, ry);
		if(surface.isSimpleCell(rx, ry)){
			System.out.println("The cell here was yummy!");
			this.eatenCells++;
		}
		if (!surface.isVirus(rx, ry))surface.move(x,y,rx,ry);
		else{
			System.out.printf("A friend in %d-%d! Let's chat for a while!\n", rx, ry);
			return new Pair(x,y);
		}
		return new Pair(rx,ry);
		
	}
}
