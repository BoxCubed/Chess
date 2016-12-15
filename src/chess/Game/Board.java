package chess.Game;

import org.newdawn.slick.GameContainer;

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

	public Board(){
		secoord[0]+=2;
		cellw+=1;
	
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        
				
				grid[w][h]=new Square(w, h, this);
			}
	
	
	System.out.println("Cell:w/h "+cellw+" "+cellh);
	
	
	}
	
	public void update(GameContainer gc) {
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){
				
				grid[w][h].update(gc);
			}
		// TODO Auto-generated method stub
		
	}
	public void render(GameContainer g){
    
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        grid[w][h].render(g);
			}
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
     * gets which square the mouse is in
     * @return the square object
     */
    Square getChosen(){
    	for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        if(grid[w][h].selected) return grid[w][h];
		        
			}
    	return null;
    	
    }
	
	
}
