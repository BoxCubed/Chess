package chess.Pieces;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import chess.enums.Pieces;
import chess.enums.Players;

public class ChessSheet{
static SpriteSheet black=null;
static SpriteSheet white;
	public ChessSheet() throws SlickException {
		//super(new Image("res/Chess-Pieces.png"), 234, 311,305-234);
		white=new SpriteSheet("res/white.png",305, 400,305-260);
		black=new SpriteSheet("res/black.png",305, 400,305-260);
		
	}
	protected static Image getPiece(Players t,Pieces p){
		try{
		switch(p){
		case Pawn:
			if(t==Players.Black){
				return black.getSprite(7, 0); 
			}
			else{
				return white.getSprite(7, 0);
			}
		case Knight:
			if(t==Players.Black){ 
				return black.getSprite(2,0);
				}
			else{ 
				return white.getSprite(2, 0);
				}
		case King: 
			if(t==Players.Black){ 
				return black.getSprite(4,0);
				}
			else{ 
				return white.getSprite(4, 0);
				}
		case Queen:
			if(t==Players.Black){ 
				return black.getSprite(5,0);
				}
			else{ 
				return white.getSprite(5, 0);
				}
		case Bishop:
			if(t==Players.Black){ 
				return black.getSprite(3,0);
				}
			else{ 
				return white.getSprite(3, 0);
				}
		case Rook:
			if(t==Players.Black){
				return black.getSprite(0, 0); 
			}
			else{
				return white.getSprite(0, 0);
			}
		
		default:	return null;
		}
		}
	catch(Exception e){
		e.printStackTrace();
	}
		return null;
	}
	

}
