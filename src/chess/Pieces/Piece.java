package chess.Pieces;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import chess.Game.Board;
import chess.Game.Square;
import chess.enums.Pieces;
import chess.enums.Players;

public abstract class Piece{
	
	int x;
	int y;
	protected Board b;
	Image image;
	
	Piece(int x,int y,Board player){
		
		this.x=x;
		this.y=y;
		this.b=player;
	}
	/**
	 * Returns what piece this is
	 * @return Pieces enum
	 */
	public abstract Pieces getID();
	/**
	 * Gets the square the piece is in.
	 * @return
	 */
	public Square getSquare(){
		return b.getSquare(x, y);
	}
	/**
	 * Whether the piece can move to the given space
	 * @param newx the new x the piece will end up in
	 * @param newy the new y the piece will end up in
	 * @return a boolean yes or no if the piece can move
	 */
	
	public abstract boolean canMove(int newx,int newy);
	/**
	 * gets all spaces that the piece can move too
	 * will be in format example {{1,2},{3,4},{5,6}}
	 * array size {@code int[x][2]}
	 * @return
	 */
	public abstract int[][] getMoveable();
	public int[] getPos(){
		int[] ret={x,y};
		return ret;
	}
	/**
	 * Call from square to render piece
	 * @param g
	 */
	public abstract void render(Graphics g);
	/**
	 * Moves piece to new location. Will not move and will return if told to move illegally 
	 * @param x
	 * @param y
	 */
	public void move(int x,int y){
		if(!canMove(x, y))
			return;
		getSquare().setPiece(null);
		this.x=x;
		this.y=y;
		getSquare().setPiece(this);
		
	}
	

}
