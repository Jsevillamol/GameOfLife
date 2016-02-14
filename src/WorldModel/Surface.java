package WorldModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import MyExceptions.SaveFileFormatError;

/**
 * Matrix of Cells
 */
public class Surface {
	
	private Cell[][] surface;
	private boolean[][] tired;
	private int rows, cols;
	public Surface(int irows, int icols){
		rows = irows; cols = icols;
		surface = new Cell[rows][cols];
		tired = new boolean[rows][cols];
	}
	public int getRows() {
		return this.rows;
	}
	public int getCols() {
		return this.cols;
	}
	/*
	public Cell getCell(int x, int y){
		return this.surface[x][y];
	}*/
	public boolean isEmpty(int x, int y){
		return this.surface[x][y] == null;
	}
	public boolean isSimpleCell(int x, int y){
		return this.surface[x][y] instanceof SimpleCell;
	}
	public boolean isVirus(int x, int y){
		return this.surface[x][y] instanceof Virus;
	}
	/**
	 * Iterates once over every cell of the world, calling their main method.
	 */
	public void moveCells(){
		//Reset the movements
		for (int x = 0; x < this.getRows(); x++)
			for (int y = 0; y < this.getCols(); y++){
				tired[x][y]=false;
		}
		
		//Move cells
		Pair pair;
		for (int x = 0; x < this.getRows(); x++)
			for (int y = 0; y < this.getCols(); y++){
				if(!this.isEmpty(x, y) && !tired[x][y]){
					pair = this.surface[x][y].move(x, y, this);
					tired[pair.getX()][pair.getY()]=true;
				}
			}
	}
	public void darwinator(){
		for (int x = 0; x < this.getRows(); x++)
			for (int y = 0; y < this.getCols(); y++){
				if (this.surface[x][y] != null && this.surface[x][y].isReadyToDie()){
					this.destroy(x,y);
				}
			}
	}
	/**
	 * Create a cell in (x,y). 
	 * @param x row
	 * @param y column
	 * @return If cell already occupied, return False.
	 */
	public boolean createCell(int x, int y) throws ArrayIndexOutOfBoundsException{
		
		if (surface[x][y] == null){
			surface[x][y] = new SimpleCell();
			return true;
		} else return false;
	}
	/**
	 * Create a virus in (x,y). 
	 * @param x row
	 * @param y column
	 * @return If cell already occupied, return False.
	 */
	public boolean createVirus(int x, int y) throws ArrayIndexOutOfBoundsException{
		
		if (surface[x][y] == null){
			surface[x][y] = new Virus();
			return true;
		} else return false;
	}
	/**
	 * Destroy cell in (x,y). 
	 * @param x row
	 * @param y column
	 * @return If cell empty, return False.
	 */
	public boolean destroy(int x, int y) throws ArrayIndexOutOfBoundsException{
		
		//if (0<=x && x<this.rows && 0<=y && y<this.cols && surface[x][y] != null){
		if (surface[x][y] != null){
			surface[x][y] = null;
			return true;
		} else return false;
	}
	
	
	public void draw(){
		for (Cell[] row : surface){
			for (Cell cell : row){
				if (cell != null) cell.print();
				else System.out.print(" - ");
			}
			System.out.print("\n");
		}
	}
	public void move(int x, int y, int rx, int ry) {
		assert(surface[rx][ry] == null);
		surface[rx][ry] = surface[x][y];
		surface[x][y] = null;
		
	}
	public void save(PrintWriter file, int x, int y) throws IOException {
		surface[x][y].save(file);
	}
	
	public void load(BufferedReader file) throws IOException, SaveFileFormatError{
		String[] s;
		int x,y;
		while(file.ready()){
			s = file.readLine().split(" ");
			x = Integer.parseInt(s[0]);
			y = Integer.parseInt(s[1]);
			
			if (s[2].equalsIgnoreCase("simple")){
				int given = Integer.parseInt(s[3]);
				int noMove = Integer.parseInt(s[4]);
				this.createCell(x,y,given,noMove);
			}
			else if (s[2].equalsIgnoreCase("complex")){
				int eaten = Integer.parseInt(s[3]);
				this.createVirus(x, y, eaten);
			}
			else throw new SaveFileFormatError();
		}
	}
	private void createCell(int x, int y, int given, int noMove) {
		surface[x][y]= new SimpleCell(given,noMove);
	}
	private void createVirus(int x, int y, int eaten) {
		surface[x][y]= new Virus(eaten);
	}
	
}
