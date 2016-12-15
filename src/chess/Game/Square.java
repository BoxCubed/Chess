package chess.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import chess.Pieces.Piece;

public class Square extends Rectangle{

	/**
	 * 
	 */
	int x;
	int y;
	Board b;
	Piece p;
	private static final long serialVersionUID = 1L;
	public boolean selected;

	public Square(int x, int y,Board b) {
		super((float)b.getcoords(x, y)[0],(float)b.getcoords(x, y)[1], b.cellw, b.cellh);
		selected=true;
		this.x=x;
		this.y=y;
		this.b=b;
		p=null;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Make sure this is called at the update thread
	 * @param gc the game container
	 */
	void update(GameContainer gc){
		Input in=gc.getInput();
		int mx=in.getMouseX();
		int my=in.getMouseY();
		int[] crds={(int)getX(),(int)getY()};
		if((mx>crds[0] && mx<crds[0]+getWidth()) && (my>crds[1] && my<crds[1]+getHeight())){
			//System.out.println("Mouse in "+getLoc()[0]+" "+getLoc()[1]);
			selected=true;
		}else selected=false;
	}
	/**
	 * Make sure this is called in the render thread. Do not overlap with update
	 * @param gc The game container
	 */
	void render(GameContainer gc){
		Graphics g=gc.getGraphics();
		if(selected&&gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			
			
			g.setLineWidth(4);
		g.draw(this);
		g.resetLineWidth();
		//System.out.println("square "+getLoc()[0]+" "+getLoc()[1]+" clicked");
		}
		
		else if(selected)
			g.draw(this);
		
	}
	/**
	 * returns location of square on chess board in coords so 0,0 will be a,1
	 * @return look above
	 */
	public int[] getLoc(){
		int[] ret={x,y};
		return ret;
		
	}
	/**
	 * Gets the piece that is in the square.  
	 * @return the goddamn piece. What did you think? A unicorn?
	 */
	public Piece getPiece(){ return p;  }
	/**
	 * Sets the piece in this square to the specified piece, it will start being rendered immediately
	 * @param p The piece to set into the square 
	 */
	public void setPiece(Piece p){ this.p=p; }
	

}
