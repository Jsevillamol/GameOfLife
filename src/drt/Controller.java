package drt;
import WorldModel.World;
import Commands.Cmd;
import Commands.CmdParser;

import java.util.Scanner;
/**
 * Interface between user and world.
 */
public class Controller {
	
	World world;
	Scanner in;
	
	public Controller(World iworld, Scanner iin){
		this.world = iworld;
		this.in = iin;
	}
	/**
	 * Main method. Handles the game loop.
	 */
	public void startSimulation() {
		
		String s = ""; Cmd cmd;
		this.world.getSurface().draw();
		System.out.println("X Cell");
		System.out.println("* Virus");
		System.out.println("Write HELP to see a list of commands");
		while(this.world.running()){
			System.out.print("cmd > ");
			
			s = in.nextLine().toUpperCase();
			cmd = CmdParser.parse(s);
			if(cmd != null) cmd.run(this.world);
			
			this.world.getSurface().draw();
			this.in.reset();
		}
		System.out.println("End of the simulation...");
	}
}
