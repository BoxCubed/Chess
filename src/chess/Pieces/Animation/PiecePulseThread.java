package chess.Pieces.Animation;

import chess.Pieces.Piece;

public class PiecePulseThread extends Thread {
	Piece p;
	public PiecePulseThread(Piece p) {
		this.p=p;
		// TODO Auto-generated constructor stub
	}
	boolean up=true;
    @Override
	public void run() {
    	while(p.pulse){
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(p.scale>=1.7f)up=false;
    		if(p.scale<=1.2f)up=true;
    		if(up)p.scale+=0.1;
    		else p.scale-=0.1;
    		
    	}
    	p.scale=1.5f;
		// TODO Auto-generated method stub
		
	}

}
