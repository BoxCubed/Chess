package chess.Pieces;

	import org.newdawn.slick.Color;
	import org.newdawn.slick.Graphics;
	import org.newdawn.slick.geom.Circle;

	import chess.Game.Board;
	import chess.enums.Pieces;

	public class Pawn extends Piece {
Pieces pieces;
		public Pawn(int x, int y, Board b) {
			super(x, y, b);
			pieces = Pieces.Pawn;
			// TODO Auto-generated constructor stub
		}

		
		@Override
		public boolean canMove(int newx, int newy) {
			// TODO Auto-generated method stub
			if(b.getSquare(newx, newy).getPiece()==null)
			return true;
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
			g.setColor(Color.orange);
			g.fill(new Circle(getSquare().getCenterX(), getSquare().getCenterY(), 10));
		}


		@Override
		public Pieces getID() {
			// TODO Auto-generated method stub
			return null;
		}

	}


