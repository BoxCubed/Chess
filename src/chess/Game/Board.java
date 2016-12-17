package chess.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import chess.Pieces.Pawn;
import chess.Pieces.TestPiece;
import chess.enums.Players;

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
	getSquare(5, 5).setPiece(new Pawn(5, 5, this));
	getSquare(6, 6).setPiece(new Pawn(6, 6, this));
	
	new TestPiece(5, 5, this,Players.White);
	new TestPiece(6, 6, this,Players.Black);
	new TestPiece(7, 7, this,Players.White);
	new TestPiece(1, 1, this,Players.Black);
	System.out.println("Cell:w/h "+cellw+" "+cellh);
	
	
	}
	
	public void update(GameContainer gc) {
	//	if(getClicked(gc)==selection&&selection!=null){selection=null; return;}
		
		if(selection!=null&&getClicked(gc)!=null
				&&selection!=getClicked(gc)&&selection.getPiece()!=null
				&&selection.getPiece().canMove(getClicked(gc).getLoc()[0], getClicked(gc).getLoc()[1])){
			selection.getPiece().move(getClicked(gc).getLoc()[0],getClicked(gc).getLoc()[1]);
			//System.out.println("Been here");
			selection=null;
			return;
		}
		

		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){
				Square s=grid[w][h];
				
				
				grid[w][h].update(gc);
				if(getClicked(gc)==s){
					selection=s;
				s.selected=true;}
				else {s.selected=false;
				
				}
				
				//else if(selection==grid[w][h]) return;
				
				//selection=grid[w][h];
					
			}
		// TODO Auto-generated method stub
		
	}
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
    
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        grid[w][h].render(gc);
			}
		
		Graphics g=gc.getGraphics();
		if(getChosen()!=null)
			
				g.draw(getChosen());
			
	if(getSelection()==null)return;
			
				
				
				g.setLineWidth(4);
			g.draw(getSelection());
			g.resetLineWidth();
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
   public Square getSquare(int x,int y){
    return grid[x][y];	
    }
	
	
}
