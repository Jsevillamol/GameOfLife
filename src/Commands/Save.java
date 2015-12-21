package Commands;

import java.io.IOException;

import MyExceptions.CmdFormatError;
import drt.Driver;
/**
 * Saves the current game state to a plain text file.
 * @author Jaime
 *
 */
public class Save extends Cmd{
	private String fileName;
	public Save(String string) {
		fileName = string;
	}

	public Save(){}

	@Override
	public void run(Driver world) throws IOException {
		world.save(fileName);
		
	}

	@Override
	public Cmd parse(String cmd) throws CmdFormatError {
		String[]cmd1 = cmd.split(" ");
		try{
		if(cmd1[0].equalsIgnoreCase("SAVE")) return new Save(cmd1[1]);
		else return null;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError();
		}
	}

	@Override
	public String help() {
		return "SAVE file: Saves the current state to file";
	}

}
