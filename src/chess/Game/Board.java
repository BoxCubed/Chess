package chess.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Circle;

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
	 * @see Board#getcoords(char, int)
	 * @param w
	 * @param h
	 * @return coord values of iven grid numbers
	 */
    int[] getcoords(int w,int h){
		//System.out.println();
if(w>7||h>7)return null;
		
		int[] ret={secoord[0]+w*cellw,secoord[1]+h*cellh};
		return ret;
	}
	public void update(GameContainer gc,Circle c) {
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){
				if(c.intersects(grid[w][h]))
					grid[w][h].selected=true;
				else grid[w][h].selected=false;
			}
		// TODO Auto-generated method stub
		
	}
	
}
