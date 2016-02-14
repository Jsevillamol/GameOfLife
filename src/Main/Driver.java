package Main;
import MyExceptions.CmdFormatError;
import MyExceptions.CmdNotFound;
import MyExceptions.InitError;
import MyExceptions.SaveFileFormatError;
import WorldModel.ComplexWorld;
import WorldModel.SimpleWorld;
import WorldModel.World;
import Commands.Cmd;
import Commands.CmdParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Interface between user and world.
 */
public class Driver {
	
	World world;
	private Scanner in;
	private boolean running = true;
	
	private static final int ROWS = 5, COLS = 5, CELLS = 5;
	
	public Driver(Scanner iin){
		try {
			this.world = new SimpleWorld(ROWS, COLS, CELLS);
		} catch (InitError e) {
			System.out.println("The number of cells surpases the surface size!");
		}
		this.setIn(iin);
	}
	/**
	 * Main method. Handles the game loop.
	 */
	public void startSimulation() {
		running = true;
		String s = ""; Cmd cmd;
		this.world.getSurface().draw();
		System.out.println("X Cell");
		System.out.println("* Virus");
		System.out.println("Write HELP to see a list of commands");
		while(running){
			System.out.print("cmd > ");
			
			s = getIn().nextLine();
			try{
				cmd = CmdParser.parse(s);
				if(cmd != null) cmd.run(this);
				this.world.getSurface().draw();
			} catch(CmdNotFound e){
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			} catch (CmdFormatError e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			} catch (SaveFileFormatError e) {
				System.out.println("Incorrect File Format");
				//e.printStackTrace();
			} catch(NullPointerException e){
				System.out.println("No world loaded. Start a new simulation or load one.");
			} catch (InitError e) {
				System.out.println("The number of cells surpases the surface size!");
			} catch (NumberFormatException e){
				System.out.println("Incorrect format: number expected");
			}
			this.getIn().reset();
		}
		System.out.println("End of the simulation...");
	}
	
	public void step(){
		world.step();
	}
	public Scanner getIn() {
		return in;
	}
	public void setIn(Scanner in) {
		this.in = in;
	}
	public void setWorld(World iworld) {
		world = iworld;
	}
	public void load(String fileName) throws IOException, SaveFileFormatError {
		FileReader reader = new FileReader(fileName);
		BufferedReader file = new BufferedReader(reader);
		String s = file.readLine();
		World new_world;
		if(s.equalsIgnoreCase("SIMPLE")) new_world = new SimpleWorld();
		else if(s.equalsIgnoreCase("COMPLEX")) new_world = new ComplexWorld();
		else{
			file.close();
			throw new SaveFileFormatError();
		}
		new_world.load(file);
		file.close();
		world = new_world;
	}
	public void save(String fileName) throws IOException {
		PrintWriter file = new PrintWriter(new FileWriter(fileName));
		world.save(file);
		file.close();
	}
	public void stop() {
		running = false;
	}
	public void xRisk() {
		world.xRisk();
	}
	public void destroy(int x, int y) throws ArrayIndexOutOfBoundsException {
		world.destroy(x,y);
		
	}
	public void createVirus(int x, int y) throws ArrayIndexOutOfBoundsException  {
		world.createVirus(x,y);
		
	}
	public boolean isComplex() {
		return world instanceof ComplexWorld;
	}
	public void createCell(int x, int y) throws ArrayIndexOutOfBoundsException {
		world.createCell(x,y);
	}
}
