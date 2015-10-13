package WorldModel;

import java.util.Random;

public class World {
	private static final int ROWS = 5;
	private static final int COLS = 5;
	private static final int ICELLS = 5;
	
	private Surface surface;
	private int steps = 0;
	public int getSteps(){return steps;}
	
	public Surface getSurface(){
		return this.surface;
	}
	
	public World(){
		System.out.println("creating world");
		surface = new Surface(ROWS, COLS);
		Random randomGenerator = new Random();
		for (int i = 0; i < ICELLS; i++){
			int randx = randomGenerator.nextInt(ROWS);
			int randy = randomGenerator.nextInt(COLS);
			if (!surface.create(randx, randy)) i--;
		}
	}
	
	public void step(){
		moveCells();
		darwinator();
		steps++;
	}
	
	private void moveCells() {
		//Reset the movements
		for (int x = 0; x < surface.getRows(); x++)
			for (int y = 0; y < surface.getCols(); y++){
				if (surface.getCell(x, y) != null) surface.getCell(x, y).rest();
		}
		
		//Move cells
		for (int x = 0; x < surface.getRows(); x++)
			for (int y = 0; y < surface.getCols(); y++){
				if (surface.getCell(x, y) != null && !surface.getCell(x, y).isTired()){
					if (surface.moveCell(x,y)){
						if (surface.getCell(x, y).isPregnant()){
							surface.destroy(x,y);
							surface.create(x,y);
						}
						else{
							surface.destroy(x, y);
						}
					} else if (surface.getCell(x, y).isPregnant()) surface.destroy(x,y);
				}
			}
	}

	private void darwinator() {
		for (int x = 0; x < surface.getRows(); x++)
			for (int y = 0; y < surface.getCols(); y++){
				if (surface.getCell(x, y) != null && surface.getCell(x, y).isReadyToDie()){
					surface.destroy(x,y);
				}
			}
	}
	
	public void xRisk(){
		for (int x = 0; x < surface.getRows(); x++){
			for (int y = 0; y < surface.getCols(); y++){
				if (surface.getCell(x, y) != null) surface.destroy(x,y);
			}
		}
	}

	
}
