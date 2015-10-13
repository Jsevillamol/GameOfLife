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
		if (0<=x && x<this.rows && 0<=y && y<this.cols && surface[x][y] == null){
			surface[x][y] = new Cell();
			return true;
		} else return false;
	}
	
	public boolean destroy(int x, int y){
		if (0<=x && x<this.rows && 0<=y && y<this.cols && surface[x][y] != null){
			surface[x][y] = null;
			return true;
		} else return false;
	}
	
	public boolean moveCell(int x, int y) {
		if(this.surface[x][y] != null && !this.surface[x][y].isTired()){
			boolean empty_found = false;
			//System.out.printf("I am in %d-%d!", x, y);
			for (int i = Math.max(x-1,0); i<=Math.min(x+1,this.rows-1) && !empty_found; i++){
				for (int j = Math.max(y-1,0); j<=Math.min(y+1, this.cols-1) && !empty_found; j++){
					if (this.surface[i][j]== null) empty_found = true;
				}
			}
			
			if (empty_found){
				int rx, ry;
				Random randomGenerator = new Random();
				do{
					rx = Math.min(Math.max(0,x + randomGenerator.nextInt(3) - 1), this.rows-1);
					ry = Math.min(Math.max(0,y + randomGenerator.nextInt(3) - 1), this.cols-1);
				}while(this.surface[rx][ry]!= null);
				this.surface[rx][ry] = this.surface[x][y];
				this.surface[rx][ry].resetCountdownToDeath();
				//System.out.printf("I'll move to %d-%d!\n", rx, ry);
				return true;
			}else {
				//System.out.println("No place to move!");
				this.surface[x][y].increaseCountdownToDeath();
				return false;
			}
		}else return false;
	}
	
	public void draw(){
		for (Cell[] row : surface){
			for (Cell cell : row){
				if (cell != null) cell.print();
				else System.out.print(" NUL ");
			}
			System.out.print("\n");
		}
	}
	
}
