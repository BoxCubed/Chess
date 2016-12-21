package chess.Pieces;

/**
 * Moves the piece in a transition effect animation
 * @author ryan9
 *
 */
public class PieceMoveThread extends Thread {
	float x,y;
	Piece p;
	boolean move=true;
	public PieceMoveThread(Piece p,float newx,float newy) {
		// TODO Auto-generated constructor stub
		this.p=p;
        x=(int) newx;
		y=(int) newy;
	}
	
    @Override
    public void run() {
    	float prevx=p.posx,prevy=p.posy;
    	
		while(p.posx!=x||p.posy!=y){
			//System.out.println("moving"+p.posx+" "+p.posy);
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(p.posx==x){System.out.println("x done");}
    		else if(prevx>x)p.posx-=1;else p.posx+=1;
    		if(p.posy==y){System.out.println("y done");}
    		else if(prevy>y)p.posy-=1;else p.posy+=1;
    		
    	}
    	// TODO Auto-generated method stub
    	
    	
    }

}
