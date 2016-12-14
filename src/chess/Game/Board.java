package chess.Game;

import org.newdawn.slick.Graphics;

public class Board {
	int Widt=64;
	int Height=64;
	
	/**
	 * 4 digit array, first 2 is grid start, next two is grid finish
	 */
	static int[] secoord={50,60,649,654};
	static int cellw=(secoord[2]-secoord[0])/8;
	static int cellh=(secoord[3]-secoord[1])/8;

	public Board(){
	System.out.println("Cell:w/h "+cellw+" "+cellh);
	
	/*secoord[0]=52;
	secoord[1]=59;
	cellh-=2;*/
	cellw+=1;
	getcoords('h', 7);
	}
	public void render(Graphics g){
    
		for(int w=0;w<8;w++)
			for(int h=0;h<8;h++){//97 is a 98 is b and so on
		        
				g.drawRect(getcoords(w, h)[0], getcoords(w, h)[1], cellw, cellh);
			}
			
			
			//g.draw(new org.newdawn.slick.geom.Rectangle(i+, y, width, height));
			//System.out.println(i);
		
		
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
	
}
