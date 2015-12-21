package WorldModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Abstract class of cells in the world
 */
public interface Cell {
	
	/**
	 * Instructs the cell to play its turn
	 * @param surface
	 */
	abstract public Pair move(int x, int y, Surface surface);
	abstract public boolean isReadyToDie();
	
	
	abstract public void print();
	public abstract void save(PrintWriter file) throws IOException;
	
}
