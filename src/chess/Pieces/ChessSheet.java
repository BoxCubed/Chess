package chess.Pieces;

import org.newdawn.slick.Image;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;

import chess.enums.Pieces;
import chess.enums.Players;

public class ChessSheet{

static PackedSpriteSheet pieces;

	public ChessSheet() throws SlickException {
		
		
		pieces=new PackedSpriteSheet("res/pieces.def");
		
	   
		
	}
	public static Image getPiece(Players t,Pieces p){
		
		return pieces.getSprite(t.toString().toLowerCase()+p.toString());
		}
	}
	


