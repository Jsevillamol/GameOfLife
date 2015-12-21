package drt;
import java.util.Scanner;

import WorldModel.World;
/*
 * Se me ha sugerido entregar la practica en espannol.
 * Despues de meditarlo he optado por no hacerlo, atendiendo a las siguientes razones:
 * 	1) 	A pesar de lo extendido que esta el Unicode, 
 * 		el soporte de caracteres especiales es menos universal.
 * 	2)	En la gran mayoria de empresas espannolas programar en ingles es obligatorio.
 * 	3)	Las palabras clave estan en ingles, y la mezcla de idiomas resulta desagradable.
 * 
 * Happy Coding!
 */
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
		World world = new World();
		Controller controller = new Controller(world, in);
		controller.startSimulation();
		System.out.println("Exit");
	}
}
