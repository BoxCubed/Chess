package chess.Game;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

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

		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        if(b.getSquare(w, h).selected&&b.getSquare(w, h).contains(x, y)){
		        	b.getSquare(w, h).selected=false;
		        	b.selection=null;
		        }
			}

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
		if(b.selection==null)deselect=false;
		else deselect=true;
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
