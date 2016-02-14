package Main;

import java.awt.Desktop;
import java.net.URI;
/**
 * Opens a certain URL.
 * @author Jaime
 *
 */
public class BrowseURL
{
 public static void EasterEgg()
 {
	 try{
 Desktop d=Desktop.getDesktop();

 d.browse(new URI("https://www.youtube.com/watch?v=C2vgICfQawE"));
	 }catch(Exception e){}
 }
}
