package chess.Game;

import org.newdawn.slick.geom.Rectangle;

public class Square extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Square(int x, int y,Board b) {
		super((float)b.getcoords(x, y)[0],(float)b.getcoords(x, y)[1], Board.cellw, Board.cellh);
		
		// TODO Auto-generated constructor stub
	}
	

}
