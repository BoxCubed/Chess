package chess.Pieces;

	import org.newdawn.slick.Graphics;

import chess.Game.Board;
import chess.enums.Pieces;
import chess.enums.Players;

	public class Pawn extends Piece {
Pieces pieces;
protected boolean moved=false;
		public Pawn(int x, int y, Board b,Players team) {
			super(x, y, b,team);
			pieces = Pieces.Pawn;
			// TODO Auto-generated constructor stub
		}

		
		@Override
		public boolean canMove(int newx, int newy) {
			// TODO Auto-generated method stub
			
			if(b.getSquare(newx, newy).getPiece()==null&&newy<=y+2&&!(newy<y)&&newx==x)if(moved&&newy==y+2)return false;else return true;
			if(b.getSquare(newx, newy).getPiece()==null)return false;
			if(b.getSquare(newx, newy).getPiece().getTeam()!=getTeam()&&(newx==x+1||newx==x-1)&&newy==y+1) return true;
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


		@Override
		public Pieces getID() {
			// TODO Auto-generated method stub
			return pieces;
		}

	}


