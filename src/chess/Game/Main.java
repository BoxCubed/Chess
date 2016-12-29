package chess.Game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

public class Main {
	private static AppGameContainer appgc;
public static void main(String[] a){
	try
	{
		
		//appgc = new AppGameContainer(new ChessGame("Chess"));

		ScalableGame s=new ScalableGame(new States(), 705, 720,false);

		appgc = new AppGameContainer(s);
		appgc.setDisplayMode(705, 720, false);
		appgc.start();
	    
		
	}
	catch (SlickException ex)
	{
		Logger.getLogger(ChessGame.class.getName()).log(Level.SEVERE, null, ex);
	}
}
public static void setResolution(int width, int height, boolean isFullScreen) {
    try {
       appgc.setDisplayMode(width, height, isFullScreen);
    } catch (SlickException e) {
       e.printStackTrace();
    }
 }
}

