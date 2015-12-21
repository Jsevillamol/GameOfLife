package WorldModel;

import java.util.Random;
/**
 * Superior layer of the virtual automata.
 */
public class World {
	
	private static final int ROWS = 5;
	private static final int COLS = 5;
	private static final int ICELLS = 5;
	private static final int IVIRUS = 5;
	
	private Surface surface;
	private boolean running = true;
	private int steps = 0;
	public int getSteps(){return steps;}
	
	public Surface getSurface(){
		return this.surface;
	}
	
	public World(){
		System.out.println("creating world");
		reset();
	}
	
	public void reset(){
		surface = new Surface(ROWS, COLS);
		Random randomGenerator = new Random();
		for (int i = 0; i < ICELLS; i++){
			int randx = randomGenerator.nextInt(ROWS);
			int randy = randomGenerator.nextInt(COLS);
			if (!surface.createCell(randx, randy)) i--;
		}
		for (int i = 0; i < IVIRUS; i++){
			int randx = randomGenerator.nextInt(ROWS);
			int randy = randomGenerator.nextInt(COLS);
			if (!surface.createVirus(randx, randy)) i--;
		}
	}
	
	/**
	 * Executes a turn of the game
	 */
	public void step(){
		
		moveCells();
		darwinator();
		steps++;
	}
	
	/**
	 * Iterates once over every cell of the world, calling their main method.
	 */
	private void moveCells() {
		
		surface.moveCells();
		//If you think delegating this to Surface is pointless, you are not alone...
	}
	/**
	 * Destroys cells who have to die according to the rules.
	 */
	private void darwinator() {
		
		surface.darwinator();
		//Same as above
	}
	/**
	 * Destroys every cell in the world.
	 */
	public void xRisk(){
		
		for (int x = 0; x < surface.getRows(); x++){
			for (int y = 0; y < surface.getCols(); y++){
				if (!surface.isEmpty(x,y)) surface.destroy(x,y);
			}
		}
	}

	public boolean running() {
		return running;
	}
	public void stop(){
		running = false;
	}

	
}
