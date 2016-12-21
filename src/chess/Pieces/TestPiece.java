package chess.Pieces;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import chess.Game.Board;
import chess.enums.Pieces;
import chess.enums.Players;

public class TestPiece extends Piece {
/**
 * this piece moves anywhere and can kill anything
 * renders a cirlce for it has no image
 * test purposes only
 * This piece has a serious toll on the fps of the game due to the game rendering every space it can move too
 * @param x
 * @param y
 * @param b
 * @param team
 */
	public TestPiece(int x, int y, Board b,Players team) {
		super(x, y, b,team);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pieces getID() {
		// TODO Auto-generated method stub
		return Pieces.Queen;
	}

	@Override
	public boolean canMove(int newx, int newy) {
		// TODO Auto-generated method stub
		
		if(b.getSquare(newx, newy).getPiece()==null||b.getSquare(newx, newy).getPiece().getTeam()!=getTeam())
		return true;
		//Deselection_Listener.deselect=false;
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
	
		
	renderImage();
		//g.setColor(Color.black);
	}

}
