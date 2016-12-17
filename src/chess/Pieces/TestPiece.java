package chess.Pieces;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import chess.Game.Board;
import chess.Game.Deselection_Listener;
import chess.enums.Pieces;

public class TestPiece extends Piece {
/**
 * this piece moves anywhere and can kill anything
 * renders a cirlce for it has no image
 * test purposes only
 * @param x
 * @param y
 * @param b
 * @param team
 */
	public TestPiece(int x, int y, Board b,Pieces team) {
		super(x, y, b,team);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pieces getID() {
		// TODO Auto-generated method stub
		return Pieces.Bishop;
	}

	@Override
	public boolean canMove(int newx, int newy) {
		// TODO Auto-generated method stub
		
		if(b.getSquare(newx, newy).getPiece()==null||b.getSquare(newx, newy).getPiece().getTeam()!=getTeam())
		return true;
		Deselection_Listener.deselect=false;
		return false;
	}

	@Override
	public int[][] getMoveable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		if(getTeam()==Pieces.White)
			g.setColor(Color.orange);
		else g.setColor(Color.red);
		g.fill(new Circle(getSquare().getCenterX(), getSquare().getCenterY(), 10));
		g.setColor(Color.black);
	}

}
