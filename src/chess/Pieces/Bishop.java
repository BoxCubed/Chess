package chess.Pieces;



import javax.sound.sampled.EnumControl.Type;

import org.newdawn.slick.Graphics;

import chess.Game.Board;
import chess.enums.Pieces;
import chess.enums.Players;

public class Bishop extends Piece{

	Pieces pieces; 
	
	Bishop(int x, int y, Board player) {
		super(x, y, player);
	pieces = Pieces.Bishop;
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
