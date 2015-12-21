package WorldModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/**
 * Normal cells, that move randomly and reproduce after certain steps.
 * @author Jaime
 *
 */
public class SimpleCell implements Cell{
	private static final int REP_STEPS = 3;
	private static final int DIE_STEPS = 3;
	private int givenSteps;
	private int noMoveSteps;
	public SimpleCell(int igiven, int inoMove) {
		givenSteps=igiven; noMoveSteps = inoMove;
	}
	public SimpleCell() {}
	/**
	 * Shows if the cell is ready to reproduce, and resets counter to 0
	 * @return True if ready to reproduce
	 */
	public boolean isPregnant(){
		
		if (givenSteps > REP_STEPS){
			givenSteps = 0;
			return true;
		}
		else return false;
	}
	public boolean isReadyToDie(){
		return noMoveSteps >= DIE_STEPS;
	}
	
	public void resetCountdownToDeath(){
		this.noMoveSteps = 0;
		this.givenSteps++;
	}
	
	public void increaseCountdownToDeath(){
		this.noMoveSteps++;
	}
	
	@Override
	public void print(){
		//System.out.printf(" %d-%d ",this.givenSteps, this.noMoveSteps);
		System.out.printf(" X ");
	}
	
	@Override
	public Pair move(int x, int y, Surface surface) {
		boolean empty_found = false;
		System.out.printf("I am a Cell in %d-%d!", x, y);
		//Look for an empty space
		for (int i = Math.max(x-1,0); i<=Math.min(x+1,surface.getRows()-1) && !empty_found; i++){
			for (int j = Math.max(y-1,0); j<=Math.min(y+1, surface.getCols()-1) && !empty_found; j++){
				if (surface.isEmpty(i, j)) empty_found = true;
			}
		}
		
		if (empty_found){
			int rx, ry;
			Random randomGenerator = new Random();
			do{
				rx = Math.min(Math.max(0,x + randomGenerator.nextInt(3) - 1), surface.getRows()-1);
				ry = Math.min(Math.max(0,y + randomGenerator.nextInt(3) - 1), surface.getCols()-1);
			}while(!surface.isEmpty(rx, ry));
			System.out.printf("I'll move to %d-%d!\n", rx, ry);
			this.resetCountdownToDeath();
			surface.move(x,y,rx,ry);
			if(this.isPregnant()) surface.createCell(x, y);
			return new Pair(rx,ry);
		}else {
			System.out.println("No place to move!");
			if(this.isPregnant()) this.noMoveSteps += DIE_STEPS;
			else this.increaseCountdownToDeath();
			return new Pair(x,y);
		}
		
	}
	@Override
	public void save(PrintWriter file) throws IOException {
		file.println("simple " + this.givenSteps +" " + this.noMoveSteps);
	}
}
