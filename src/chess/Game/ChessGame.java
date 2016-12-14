
package chess.Game;
import java.util.Scanner;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ChessGame extends BasicGame
{
	int count=0;
	int delta;
	Image bg;
	Scanner i=new Scanner(System.in);
	Board b;
	public ChessGame(String gamename)
	{
		super(gamename);
		//i=new Scanner(System.in);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		//gc.getGraphics().setBackground(Color.orange);
		bg=new Image("res/board.png");
		b=new Board();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {//delta is time the last update was called. measured in ms 
		                                                                   //if called 10 times a second, its 100ms
		//gc.getGraphics().setBackground(Color.orange);
		this.delta=delta;
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{ 
		g.setColor(Color.black);
		
		bg.draw(0, 0, gc.getWidth(), gc.getHeight());
		b.render(g);
		g.drawString("x: "+gc.getInput().getMouseX(), gc.getInput().getMouseX()-20, gc.getInput().getMouseY()+10);
		g.drawString("y: "+gc.getInput().getMouseY(), gc.getInput().getMouseX()-20,gc.getInput().getMouseY()+25);
		
		g.drawString("Chess", 100, 100);
		g.drawString(""+delta, 20, 20);
		
	
	}
}