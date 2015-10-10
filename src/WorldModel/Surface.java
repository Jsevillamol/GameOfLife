package WorldModel;

import java.util.Random;

public class Surface {
	private Cell[][] surface;
	private int rows, cols;
	public Surface(int irows, int icols){
		rows = irows; cols = icols;
		surface = new Cell[rows][cols];
	}
	public int getRows() {
		return this.rows;
	}
	public int getCols() {
		return this.cols;
	}
	public Cell getCell(int x, int y){
		return this.surface[x][y];
	}
	public boolean create(int x, int y){
		if (surface[x][y] == null){
			surface[x][y] = new Cell();
			return true;
		} else return false;
	}
	
	public boolean destroy(int x, int y){
		if (surface[x][y] != null){
			surface[x][y] = null;
			return true;
		} else return false;
	}
	
	public boolean moveCell(int x, int y) {
		boolean empty_found = false;
		for (int i = x-1; i<=x+1 && !empty_found; i++){
			for (int j = y-1; j<=y+1 && !empty_found; j++){
				if (this.surface[i][j]== null) empty_found = true;
			}
		}
		
		if (empty_found){
			int rx, ry;
			Random randomGenerator = new Random();
			do{
				rx = x + randomGenerator.nextInt(3) - 1;
				ry = y + randomGenerator.nextInt(3) - 1;
			}while(this.surface[rx][ry]== null);
			this.surface[rx][ry] = this.surface[x][y];
			this.surface[x][y] = null;
			this.surface[rx][ry].resetCountdownToDeath();
			return true;
		}else {
			this.surface[x][y].increaseCountdownToDeath();
			return false;
		}
	}
	
	public void draw(){
		for (Cell[] row : surface){
			for (Cell cell : row){
				if (cell != null) cell.print();
				else System.out.print(" NUL ");
			}
			System.out.print("/n");
		}
	}
}
