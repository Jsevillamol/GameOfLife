package WorldModel;

public class Cell {
	private static final int REP_STEPS = 3;
	private static final int DIE_STEPS = 3;
	private int givenSteps;
	private int noMoveSteps;
	private boolean tired;
	public boolean isTired() {
		return tired;
	}
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
		this.tired = true;
	}
	
	public void increaseCountdownToDeath(){
		this.noMoveSteps++;
	}
	
	public void print(){
		System.out.printf(" %d-%d ",this.givenSteps, this.noMoveSteps);
	}
	public void rest() {
		this.tired = false;
	}
}
