package chess;
import java.util.Scanner;

import org.newdawn.slick.BasicGame;
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
	public ChessGame(String gamename)
	{
		super(gamename);
		//i=new Scanner(System.in);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		//gc.getGraphics().setBackground(Color.orange);
		bg=new Image("res/board.png");
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
		bg.draw(0, 0, gc.getWidth(), gc.getHeight());
		g.drawString("Chess", 100, 100);
		g.drawString(""+delta, 20, 20);
		
	
	}
	}