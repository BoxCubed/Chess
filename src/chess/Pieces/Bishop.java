package chess.Pieces;



import org.newdawn.slick.Graphics;

import chess.Game.Board;
import chess.enums.Pieces;
import chess.enums.Players;

public class Bishop extends Piece{

	Pieces pieces; 
	
	public Bishop(int x, int y, Board player, Players team) {
		super(x, y, player,team);
	pieces = Pieces.Bishop;
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
	}

}
