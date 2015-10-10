package WorldModel;

public class World {
	private static final int ROWS = 10;
	private static final int COLS = 10;
	private static final int ICELLS = 10;
	
	private Surface surface;
	private int steps = 0;
	public int getSteps(){return steps;}
	
	public Surface getSurface(){
		return this.surface;
	}
	
	public World(){
		surface = new Surface(ROWS, COLS);
		for (int i = 0; i < ICELLS; i++){
			int randx = 5;
			int randy = 5;
			if (surface.getCell(randx,randy) == null)
				surface.create(randx, randy);
			else i--;
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
				if (surface.getCell(x, y) != null) surface.getCell(x, y).unmove();
		}
		
		//Move cells
		for (int x = 0; x < surface.getRows(); x++)
			for (int y = 0; y < surface.getCols(); y++){
				if (surface.getCell(x, y) != null && !surface.getCell(x, y).isMoved()){
					if (surface.moveCell(x,y)){
						if (surface.getCell(x, y).isPregnant()) surface.create(x,y);
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
		for (int x = 0; x < surface.getRows(); x++)
			for (int y = 0; y < surface.getCols(); y++){
				if (surface.getCell(x, y) != null) surface.destroy(x,y);
			}
	}

	
}
