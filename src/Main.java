import java.util.Scanner;
import WorldModel.World;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		World world = new World();
		System.out.println("Start");
		Controller controller = new Controller(world, in);
		controller.startSimulation();
		System.out.println("Exit");
	}
}
