package drt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Shows files in the console (deprecated)
 * @author Jaime
 *
 */
public class ReadFile {

public static void Read(String file) {
	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		   String line = null;
		   while ((line = br.readLine()) != null) {
		       System.out.println(line);
		   }
		}
	catch (IOException e){
		System.out.println(e.getMessage());
	}
}
}
