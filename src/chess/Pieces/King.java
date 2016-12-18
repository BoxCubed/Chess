package chess.Pieces;

import org.newdawn.slick.Graphics;

import chess.Game.Board;
import chess.enums.Pieces;
import chess.enums.Players;

public class King extends Piece{

	King(int x, int y, Board b,Players team) {
		super(x, y, b,team);
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
