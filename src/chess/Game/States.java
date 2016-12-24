package chess.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import chess.Pieces.ChessSheet;

public class States extends StateBasedGame {

	public States() {
		super("Chess");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		new ChessSheet();
		addState(new MainMenu());
		addState(new ChessGame());
		

	}

}
