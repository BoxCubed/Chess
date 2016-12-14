package chess.Game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
public static void main(String[] a){
	try
	{
		AppGameContainer appgc;
		appgc = new AppGameContainer(new ChessGame("Chess"));
		appgc.setDisplayMode(705, 720, false);
		appgc.start();
		
	}
	catch (SlickException ex)
	{
		Logger.getLogger(ChessGame.class.getName()).log(Level.SEVERE, null, ex);
	}
}
}

