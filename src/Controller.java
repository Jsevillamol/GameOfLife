import WorldModel.World;
import java.util.Scanner;

public class Controller {
	World world;
	Scanner in;
	
	public Controller(World iworld, Scanner iin){
		this.world = iworld;
		this.in = iin;
	}

	public void startSimulation() {
		String cmd = ""; int x, y;
		System.out.println("Write HELP to see a list of commands");
		while(cmd != "EXIT"){
			System.out.print("cmd > ");
			cmd = in.next().toUpperCase();
			switch(cmd){
				case "STEP":
					this.world.step();
					System.out.printf("Turn number: %d /n", world.getSteps());
					break;
				case "HELP":
					System.out.println("Not implemented!");
					break;
				case "RESET":
					this.world = new World();
					System.out.println("Reset in 3, 2, 1,...");
					break;
				case "METEOR FALL":
					this.world.xRisk();
					System.out.println("Rock falls, everyone dies");
					break;
				case "CREATE":
					x = in.nextInt(); y = in.nextInt();
					if (!this.world.getSurface().create(x, y));
						System.out.println("Location full!");
					break;
				case "DESTROY":
					x = in.nextInt(); y = in.nextInt();
					if(!this.world.getSurface().destroy(x, y));
						System.out.println("Location empty!");
					break;
			}
			this.world.getSurface().draw();
			this.in.reset();
		}
		System.out.println("End of the simulation...");
	}
}
