package Main;
import java.util.Scanner;

/**
 * Main class.
 * @author Jaime
 *
 */
public class Main {
	public static void main(String[] args){
		System.out.println("Start");
		Scanner in = new Scanner(System.in);
		System.out.println("Scanner imported");
		Driver controller = new Driver(in);
		controller.startSimulation();
		System.out.println("Exit");
	}
}
