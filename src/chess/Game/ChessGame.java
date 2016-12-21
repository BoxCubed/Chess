
package chess.Game;
import java.util.Scanner;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import chess.Pieces.ChessSheet;
import chess.enums.State;

public class ChessGame extends BasicGame
{
	private static State state;
	int count=0;
	int delta;
	Image bg;
	Scanner i=new Scanner(System.in);
	Board b;
	
	
	public ChessGame(String gamename)
	{
		super(gamename);
		state=State.WHITE_TURN;
		//i=new Scanner(System.in);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		//gc.getGraphics().setBackground(Color.orange);
		bg=new Image("res/board.png");
		b=new Board();
		gc.getInput().addMouseListener(new Deselection_Listener(b));
	
		gc.getGraphics().setBackground(Color.white);
		gc.setShowFPS(false);
		new ChessSheet();
		
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {//delta is time the last update was called. measured in ms 
		                                                                   //if called 10 times a second, its 100ms
		
	
		b.update(gc);
		this.delta=delta;
		
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{ 
		g.setColor(Color.black);
		
		//bg.draw(0, 0, gc.getWidth(), gc.getHeight());
		b.render(gc);
		g.drawString("x: "+gc.getInput().getMouseX(), gc.getInput().getMouseX()-20, gc.getInput().getMouseY()+10);
		g.drawString("y: "+gc.getInput().getMouseY(), gc.getInput().getMouseX()-20,gc.getInput().getMouseY()+25);
		g.drawString("FPS: "+gc.getFPS(), 20, 20);
		if(getState()==State.BLACK_TURN)g.drawString("Black's Turn", 704/2, 20);	else g.drawString("White's Turn", 704/2, 20);
		if(b.getChosen()==null) return;
		g.drawString("In Square: "+(char)(b.getChosen().getLoc()[0]+97)+" "+(b.getChosen().getLoc()[1]+1
			
				/*-1+8 used simple graph math to invert numbers so 0 becomes 8, 7 is 1 so on. 
		equation is y=-x+8*/), 40, 0);
		
		
		
	
	}
	/**
	 * Gets state game is in
	 * @return the state as a enum
	 */
	public static State getState(){
		return state;
	}
	/**
	 * Sets state of game
	 * @param s the state enum to set too
	 */
	public static void setState(State s){
		state=s;
		
	}
}