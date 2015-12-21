package WorldModel;

/**
 * Abstract class of cells in the world
 */
public abstract class Cell {
	
	/**
	 * Instructs the cell to play its turn
	 * @param surface
	 */
	abstract public Pair move(int x, int y, Surface surface);
	abstract public boolean isReadyToDie();
	
	
	abstract public void print();
	
}
