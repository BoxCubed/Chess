package util;


import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

/**
 * A simple Menu Button 
 * Works with slick and requires update and render methods to be called
 * every loop
 * @author ryan9
 * 
 *
 */
public class MenuButton{
	Image i=null;
	Image ci=null;
	float x,y;
	Font f,cf;
	TrueTypeFont name,cname;
	Rectangle r;
	boolean chosen,lock=false;
	Color col=Color.blue;
	Color ccol=Color.white;
	private int mx,my;//mouse x and y
	

	boolean useImage(){
		if(i==null)return false;
				return true;
	}
	String s=null;
	MenuListener l=null;
	public MenuButton(Image i,float x,float y,MenuListener l){
		this.i=i;
		this.l=l;
		this.x=x;
		this.y=y;
		i.draw(x, y);
		r=new Rectangle(x, y, x, y);
		
		
		
	}
	public MenuButton(Image i,Image ci,float x,float y,MenuListener l){
		this.i=i;
		this.l=l;
		this.x=x;
		this.y=y;
		this.ci=ci;
		i.draw(x, y);
		r=new Rectangle(x, y, x, y);
		
		
	}
public 	MenuButton(String i,Font f,float x,float y,MenuListener l){
		this(i,f,f,x,y,l);
		
		
	}
	public MenuButton(String i,Font f,Font cf,float x,float y,MenuListener l){
		s=i;
		this.f=f;
		this.x=x;
		this.y=y;
		this.cf=cf;
		this.l=l;
		name=new TrueTypeFont(f, true);
		cname=new TrueTypeFont(cf, true);
				r=new Rectangle(x, y, x, y);
		
	}
	/**
	 * Call when updating
	 * @param gc
	 * provide Slick GameContainer
	 */
	public void update(GameContainer gc){
		if(!isLocked())
		setCollisionBounds();
		Input in=gc.getInput();
		mx=in.getMouseX();
		my=in.getMouseY();
		if((mx>x && mx<x+r.getWidth()) && (my>y && my<y+r.getHeight())){
			chosen=true;
		l.chosen(this);}
		
		else {chosen=false;
		l.notChosen(this);}
		
		if(chosen&&in.isMousePressed(0))
			l.clicked(this);
		if(chosen&&in.isMousePressed(1))
			l.rightclicked(this);
		
		
		
		
	}
	/**
	 * Call when rendering
	 * @param g
	 * provide Slick Graphics 
	 */
	public void render(Graphics g){
		if(useImage()){
			
			
			if(!chosen || (chosen&&ci==null))
				i.draw(x,y);
			else if(ci!=null)
				ci.draw(x, y);
			else throw new NullPointerException("Could not draw Button Image");
			
		}else{
			if(chosen)cname.drawString(x, y, s,ccol);else name.drawString(x, y, s,col);
			
			
		}
		
		
		
		
		
	}
	public void setX(float x){this.x=x;}
	public void setY(float y){this.y=y;}
	public void setMessage(String s){this.s=s;}
	/**
	 * Should be used to detect collisions without the use of the mouse
	 * @return
	 * the rectangle the menu button is enclosed in
	 */
	public Rectangle getRect(){return r;}
	public void setColor(Color c){this.col=c;}
	public void setChosenColor(Color c){this.ccol=c;}
	public boolean isChosen(){return chosen;}
	public void addListener(MenuListener l){this.l=l;}
	/**
	 *Sets an image to the button
	 *Note: 
	 * If object was created with a string, setting this will stop rendering a string and render an image instead
	 * to change back just set this to null. rendering both isn't possible...yet
	 * 
	 * 
	 */
	public void setImage(Image i){this.i=i;}
	public void setChosenImage(Image i){ci=i;}
	public void setChosen(boolean c){chosen=c;}
	public float getY(){return y;}
	public float getX(){return x;}
	/**
	 * Allows to lock the collision box so it is not moved with the image/text
	 * Should be used if a custom one is to be made with {@code getRect()}
	 */
	public  void setCollisionLock(boolean lock){this.lock=lock;}
	public boolean isLocked(){return lock;}
	public MenuButton getInstance(){return this;}
	/**
	 * Uses a linear equation in order to space the button evenly with the others. Only edits the Y value
	 * @param number 
	 * The order of the button from top down. (Assuming you are using an array so 0 should be the first)
	 * @param spacing the amount to space the button from the previous not neccesaraly in pixels
	 * @param startPos the y position of the first button. Should be universal throughout your list.
	 */
	public void orderButton(int number,int spacing, int startPos){
		setY(number*spacing+startPos);
		setCollisionBounds();
		
	}
	private void setCollisionBounds(){
		if(useImage())
		r.setBounds(x, y,x+ i.getWidth(),y+ i.getHeight());
		else if(!isChosen()) r.setBounds(x, y, name.getWidth(s), name.getHeight());
		else r.setBounds(x, y, cname.getWidth(s), cname.getHeight());
		}


}
