package chess.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class Square extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean selected;

	public Square(int x, int y,Board b) {
		super((float)b.getcoords(x, y)[0],(float)b.getcoords(x, y)[1], b.cellw, b.cellh);
		selected=true;
		// TODO Auto-generated constructor stub
	}
	void render(GameContainer gc){
		Graphics g=gc.getGraphics();
		if(selected&&gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			
			
			g.setLineWidth(4);
		g.draw(this);
		g.resetLineWidth();
		}
		
		else if(selected)
			g.draw(this);
		
	}
	

}
