package Commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import MyExceptions.CmdFormatError;
import MyExceptions.SaveFileFormatError;
import Main.Driver;
/**
 * Loads a World from a plain text file.
 * @author Jaime
 *
 */
public class Load extends Cmd {
	private String fileName;
	public Load(){};
	public Load(String ifileName){
		fileName = ifileName;
	}
	
	@Override
	public void run(Driver world) throws IOException, SaveFileFormatError,FileNotFoundException {
		world.load(fileName);
	}

	@Override
	public Cmd parse(String cmd) throws CmdFormatError {
		String[]cmd1 = cmd.split(" ");
		try{
			if(cmd1[0].equalsIgnoreCase("LOAD")) return new Load(cmd1[1]);
			else return null;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new CmdFormatError();
		}
		
	}

	@Override
	public String help() {
		return "LOAD FILE: Loads the file FILE";
	}

}
