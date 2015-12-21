package WorldModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import MyExceptions.InitError;
/**
 * A World with only Simple Cells.
 * @author Jaime
 *
 */
public class SimpleWorld extends World {
	private int cells;
	public SimpleWorld(int irows, int icols, int icells) throws InitError{
		super(irows, icols);
		cells = icells;
		reset();
	}
	public SimpleWorld() {	}
	@Override
	public void reset() throws InitError {
		if(cells > rows*cols) throw new InitError();
		Random randomGenerator = new Random();
		for (int i = 0; i < cells; i++){
			int randx = randomGenerator.nextInt(rows);
			int randy = randomGenerator.nextInt(cols);
			if (!surface.createCell(randx, randy)) i--;
		}

	}
	@Override
	public void save(PrintWriter file) throws IOException{
		file.println("simple");
		super.save(file);
	}

}
