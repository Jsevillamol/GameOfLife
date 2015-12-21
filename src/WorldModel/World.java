package WorldModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import MyExceptions.InitError;
import MyExceptions.SaveFileFormatError;
/**
 * Superior layer of the virtual automata.
 */
public abstract class World {
	
	protected int rows, cols;
	
	protected Surface surface;
	private int steps = 0;
	public int getSteps(){return steps;}
	
	public Surface getSurface(){
		return this.surface;
	}
	
	public World(){
		surface = null;
		rows = cols = 0;
	}
	
	public World(int irows, int icols){
		rows = irows; cols = icols;
		surface = new Surface(rows, cols);
	}
	
	public abstract void reset() throws InitError;
	
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

	public void save(PrintWriter file) throws IOException{
		file.println(rows);
		file.println(cols);
		for (int x = 0; x < surface.getRows(); x++){
			for (int y = 0; y < surface.getCols(); y++){
				if (!surface.isEmpty(x,y)){
					file.print(x+" "+y+" ");
					surface.save(file,x,y);
				}
			}
		}
	}

	public void load(BufferedReader file) throws IOException, SaveFileFormatError {
		try{
			rows = Integer.parseInt(file.readLine());
			cols = Integer.parseInt(file.readLine());
		}catch(NumberFormatException e){
			throw new SaveFileFormatError();
		}
		surface = new Surface(rows, cols);
		surface.load(file);
		
	}

	public void destroy(int x, int y) {
		surface.destroy(x, y);
		
	}
	
	public void createCell(int x, int y){
		surface.createCell(x, y);
	}
	
	public void createVirus(int x, int y){
		surface.createVirus(x, y);
	}
	
	
}
