package chess.Pieces;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import chess.Game.Board;
import chess.Game.Square;
import chess.enums.Pieces;
import chess.enums.Players;

public abstract class Piece{
	
	int x,y;
	float posx,posy;
	protected Board b;
	Image image;
	private Players team;
	
	
		

	//Pieces team;
	Piece(int x,int y,Board b,Players team){
		this.team=team;

		this.x=x;
		this.y=y;

		this.b=b;

		this.b=b;
		b.getSquare(x, y).setPiece(this);
		posx=(int) getSquare().getX();
		posy=(int) getSquare().getY();
		

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
	/**
	 * Get where the piece in in format 0,0
	 * @return loc in an array
	 */
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
		PieceMoveThread move = new PieceMoveThread(this, getSquare().getX(), getSquare().getY());
		move.start();
		if(this instanceof Pawn){Pawn p=(Pawn)this;p.moved=true;}
		
	}
	/**
	 * Gets the Team the piece is in.
	 * @return white or black
	 */
	public Players getTeam(){
		return team;
	}
	/**
	 * Renders image of the piece neatly without any alignment needed on your part
	 */
	protected void renderImage(){
		Image i=ChessSheet.getPiece(getTeam(), getID());
		i.draw(posx+3, posy,1.5f);
		
	}
	

}
