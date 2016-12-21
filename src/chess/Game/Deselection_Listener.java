package chess.Game;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import chess.enums.Players;
import chess.enums.State;

public class Deselection_Listener implements MouseListener {
Board b;
public static boolean deselect=false;
	public Deselection_Listener(Board b) {
		// TODO Auto-generated constructor stub
		this.b=b;
		System.out.println("init deselection");
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		if(!deselect)return;
		if(b.getSelection()==null)return;
		if(button!=Input.MOUSE_LEFT_BUTTON)return;

		b.selection=null;

	}
	@Override
	public void setInput(Input input) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		Square s=b.getSquare((float)x, (float)y);
		Players turn;
		if(s==null)return;
		if(b.selection==null&&s.getPiece()!=null){deselect=false;b.selection=s;return;}
		if(b.selection==s){deselect=true; return;}
		
		if(ChessGame.getState()==State.WHITE_TURN)turn=Players.White; else turn=Players.Black;
		
		if(b.selection!=null&&s!=null&&b.selection!=s&&b.selection.getPiece()!=null
				&&b.selection.getPiece().canMove(s.getLoc()[0], s.getLoc()[1])&&turn==b.selection.getPiece().getTeam()){
			b.selection.getPiece().move(s.getLoc()[0],s.getLoc()[1]);
			deselect=true;
			if(turn==Players.Black)ChessGame.setState(State.WHITE_TURN);else ChessGame.setState(State.BLACK_TURN);
		}else if(s.getPiece()!=null){
			deselect=false;b.selection=s;return;
		}
		
		/*if(selection!=null&&getClicked(gc)!=null
		&&selection!=getClicked(gc)&&selection.getPiece()!=null
		&&selection.getPiece().canMove(getClicked(gc).getLoc()[0], getClicked(gc).getLoc()[1])){
	selection.getPiece().move(getClicked(gc).getLoc()[0],getClicked(gc).getLoc()[1]);
	//System.out.println("Been here");
	selection=null;
	return;
}*/
	
	}

	

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub

	}

}
