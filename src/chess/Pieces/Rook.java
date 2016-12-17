package chess.Pieces;

import org.newdawn.slick.Graphics;

import chess.Game.Board;
import chess.enums.Pieces;

public class Rook extends Piece{

	Rook(int x, int y, Board b) {
		super(x, y, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pieces getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMove(int newx, int newy) {
		// TODO Auto-generated method stub
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
		
	}

}
