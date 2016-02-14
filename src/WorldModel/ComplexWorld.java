package WorldModel;

import java.io.PrintWriter;
import java.util.Random;

import MyExceptions.InitError;
/**
 * A World with both SimpleCells and Virus.
 * @author Jaime
 *
 */
public class ComplexWorld extends World {
	private int cells, virus;
	public ComplexWorld(int irows, int icols, int icells, int ivirus) throws InitError{
		super(irows, icols);
		cells = icells; virus = ivirus;
		reset();
	}
	public ComplexWorld() {	}
	@Override
	public void reset() throws InitError {
		if(virus+cells > rows*cols) throw new InitError();
		Random randomGenerator = new Random();
		for (int i = 0; i < cells; i++){
			int randx = randomGenerator.nextInt(rows);
			int randy = randomGenerator.nextInt(cols);
			if (!surface.createCell(randx, randy)) i--;
		}
		for (int i = 0; i < virus; i++){
			int randx = randomGenerator.nextInt(rows);
			int randy = randomGenerator.nextInt(cols);
			if (!surface.createVirus(randx, randy)) i--;
		}
	}
	
	@Override
	protected void save_world_type(PrintWriter file) {
		file.println("complex");
		
	}
	
}
