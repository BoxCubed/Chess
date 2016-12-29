package chess.Pieces;

import chess.Game.Board;
import chess.enums.Pieces;
import chess.enums.Players;

public class Queen extends Piece {

	public Queen(int x, int y, Board b,Players team) {
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
		return false;
	}

	

	

}
