package chess.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;

import chess.Pieces.Bishop;
import chess.Pieces.King;
import chess.Pieces.Knight;
import chess.Pieces.Pawn;
import chess.Pieces.Queen;
import chess.Pieces.Rook;
import chess.Pieces.TestPiece;
import chess.enums.Players;
import chess.enums.State;

public class Board {
	int Widt=64;
	int Height=64;
	Square[][] grid=new Square[8][8];
	/**
	 * 4 digit array, first 2 is grid start, next two is grid finish
	 */
	int[] secoord={50,60,649,654};
	int cellw=(secoord[2]-secoord[0])/8;
	int cellh=(secoord[3]-secoord[1])/8;
	Square selection=null;

	public Board(){
		secoord[0]+=2;
		cellw+=1;
	boolean white=true;
	int sw=0;
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        
		      /*  if((w&1)==0)//if number is even. idk how this works but stack says it does
		        {*/
				if(sw==w){
		        	grid[w][h]=new Square(w, h, this,white);
		            white=!white;//simple toggle
		            }else{
		            	grid[w][h]=new Square(w, h, this,!white);
		            	sw=w;
		            	//white=!white;
		            }
		        
				
				
			}
	
	for(int i=0;i<=7;i++){
		new Pawn(i, 1, this, Players.Black); //This sets the position of the pawns for both players. The int i is the x value that changes 
		//while the y value stays the same because they are in the same row. 
	}
	for(int i=0;i<=7;i++){
		new Pawn(i, 6, this, Players.White);
	}
	
	new Rook(0, 0, this, Players.Black);
	new Rook(7,0, this, Players.Black);
	new Knight(1,0,this,Players.Black);
	new Knight(6,0,this,Players.Black);
	new Bishop(5,0,this,Players.Black);
	new Bishop(2,0,this,Players.Black);
	new King(3,0,this, Players.Black);
	new Queen(4,0,this,Players.Black);
	
	new Rook(0, 7, this, Players.White);
	new Rook(7,7, this, Players.White);
	new Knight(1,7,this,Players.White);
	new Knight(6,7,this,Players.White);
	new Bishop(5,7,this,Players.White);
	new Bishop(2,7,this,Players.White);
	new King(3,7,this, Players.White);
	new Queen(4,7,this,Players.White);
	
	
	
		//Still not an efficient way to place the rooks but it is easier than writing the individual location of 16 pieces
	/*for(int x=0;x>=7;x+=7){
		Boolean DoneWhite;
		do{
		new TestPiece(x, 7, this, Players.White);
		if(x==7){
			DoneWhite=true;
		}
		}while(DoneWhite = false);
		
		if(DoneWhite==true){
			x= 0; 
			new TestPiece(x, 0, this, Players.Black);
		}
		
	}*/
	
	//new Pawn(2,2,this,Players.Black);
	System.out.println("Cell:w/h "+cellw+" "+cellh);
	
	
	}
	
	public void update(GameContainer gc) {
	//	if(getClicked(gc)==selection&&selection!=null){selection=null; return;}
		
		/*if(selection!=null&&getClicked(gc)!=null
				&&selection!=getClicked(gc)&&selection.getPiece()!=null
				&&selection.getPiece().canMove(getClicked(gc).getLoc()[0], getClicked(gc).getLoc()[1])){
			selection.getPiece().move(getClicked(gc).getLoc()[0],getClicked(gc).getLoc()[1]);
			//System.out.println("Been here");
			selection=null;
			return;
		}*/
		

		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){
				Square s=grid[w][h];
				
				
				grid[w][h].update(gc);
				if(getSelection()==s){
					//selection=s;
				s.selected=true;}
				else {s.selected=false;
				
				}
				
				//else if(selection==grid[w][h]) return;
				
				//selection=grid[w][h];
					
			}
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unused")
	private Square getClicked(GameContainer gc) {
		// TODO Auto-generated method stub
		for(int w=0;w<8;w++)
		for(int h=0;h<8;h++){
	
	Square s=grid[w][h];
if(s.chosen&&gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
		return s;
		}
		return null;
	}

	public void render(GameContainer gc){
		Graphics g=gc.getGraphics();
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        grid[w][h].render(gc);
		        
			}
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        //grid[w][h].render(gc);
		        if(grid[w][h].getPiece()!=null)
		    		grid[w][h].getPiece().render(g);
		        
			}
		
		
		if(getChosen()!=null)
			
				g.draw(getChosen());
			
	if(getSelection()==null)return;
			
				
				
				g.setLineWidth(4);
			g.draw(getSelection());
			g.resetLineWidth();
			Players turn;
			if(ChessGame.getState()==State.WHITE_TURN)turn=Players.White; else turn=Players.Black;
			if(getSelection().getPiece()!=null&&getSelection().getPiece().getTeam()==turn){
				g.setColor(Color.blue);
				for(int w=0;w<8;w++)
					for(int h=0;h<8;h++){
						if(getSelection().getPiece().canMove(w, h))
							g.fill(new Circle(getSquare(w, h).getCenterX(), getSquare(w, h).getCenterY(), 10));
						
					}
				g.setColor(Color.black);
			}
			//System.out.println("square "+getLoc()[0]+" "+getLoc()[1]+" clicked");
			
			
			
		}
		
			
	/**
	 * Returns coord values on the board image the given coords represent.
	 * like a1 would give 50,60
	 * @param l the letter coord in LOWERCASE
	 * @deprecated use {@link Board#getcoords(int, int)}}
	 * @param n the number coord
	 * @return an array consisting of the coords on the image. null if out of bounds
	 */
	int[] getcoords(char l,int n){
		//System.out.println();
		
		return getcoords(Character.getNumericValue(Character.toLowerCase(l))-10, n-1);
		
		
	}
	/**
	 * Returns coord values on the board image the given coords represent where 0,0 is a,1
	 * This method is only practically useful when initialising the squares and should not be used. The squares extend rectangle
	 * so that should be used instead
	 * @see Board#getcoords(char, int)
	 * @param w
	 * @param h
	 * @return array of coord values of given grid numbers
	 */
    int[] getcoords(int w,int h){
		//System.out.println();
if(w>7||h>7)return null;
		
		int[] ret={secoord[0]+w*cellw,secoord[1]+h*cellh};
		return ret;
	}
    /**
     * get which square is chosen
     * @return the chosen one
     */
       Square getSelection(){
    	
    	
	
    	return selection;
    }
       /**
        * gets which square the mouse is in
        * @return the square object
        */

    Square getChosen(){
    	for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        if(grid[w][h].chosen) return grid[w][h];
		        
			}
    	return null;
    	
    }
    /**
     * Gets square using GRID coords like 0,0 0,1 etc
     * @param x x
     * @param y y
     * @return the square that is in that square
     */
   public Square getSquare(int x,int y){
	   if(x>7||y>7) return null;
    return grid[x][y];	
    }
   /**
    * gets the square that contains the coords given like 50,60 would be square 0,0
    * @param x
    * @param y
    * @return
    */
   public Square getSquare(float x,float y){
	   for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){
				if(grid[w][h].contains(x,y)) return grid[w][h];
			}
	   return null;
   }
   
	
	
}
