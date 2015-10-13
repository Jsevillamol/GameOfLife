package drt;
import java.util.Scanner;

import WorldModel.World;

public class Main {
	public static void main(String[] args){
		System.out.println("Start");
		Scanner in = new Scanner(System.in);
		System.out.println("Scanner imported");
		World world = new World();
		Controller controller = new Controller(world, in);
		controller.startSimulation();
		System.out.println("Exit");
	}
}
