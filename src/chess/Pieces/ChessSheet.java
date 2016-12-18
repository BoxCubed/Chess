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
		white=new SpriteSheet("res/white.png", 234, 311,305-234);
		black=new SpriteSheet("res/black.png", 234, 351,305-234);
		
	}
	protected static Image getPiece(Players t,Pieces p){
		
		switch(p){
		case Bishop:if(t==Players.Black) return black.getSprite(2,0); else return white.getSprite(2, 0);
		case Castle:if(t==Players.Black) return black.getSprite(0, 0); else return white.getSprite(0, 0);
		default:	return null;
		}
		
	}
	

}
