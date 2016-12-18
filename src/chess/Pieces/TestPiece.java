package chess.Pieces;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import chess.Game.Board;
import chess.Game.Deselection_Listener;
import chess.enums.Pieces;
import chess.enums.Players;

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
	public TestPiece(int x, int y, Board b,Players team) {
		super(x, y, b,team);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pieces getID() {
		// TODO Auto-generated method stub
		return Pieces.Castle;
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
	
		
			Image i=ChessSheet.getPiece(getTeam(), getID());
		
		i.draw(getSquare().getX(), getSquare().getY(), 0.195f);
		//g.setColor(Color.black);
	}

}
