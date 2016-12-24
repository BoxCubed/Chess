package chess.Game;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import chess.Pieces.ChessSheet;
import chess.enums.Pieces;
import chess.enums.Players;
import util.MenuButton;
import util.MenuListener;

public class MainMenu extends BasicGameState {
Random rand=new Random();
long elapsedtime;
List<MenuPiece> p=new ArrayList<MenuPiece>();
MenuButton start;
Font f=new Font("Verdana", Font.PLAIN, 40);
Font cf=new Font("Verdana", Font.BOLD, 40);
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		gc.getGraphics().setBackground(Color.darkGray);
		start=new MenuButton("Click to start", f, cf, gc.getWidth()/2-50, gc.getHeight()/2, new MenuListener() {
			
			@Override
			public void rightclicked(MenuButton m) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void notChosen(MenuButton m) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clicked(MenuButton m) {
				// TODO Auto-generated method stub
				game.enterState(1);
			}
			
			@Override
			public void chosen(MenuButton m) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		 if(elapsedtime >= 1000) { //simple delta timer
			elapsedtime=0;
			p.add(new MenuPiece(rand.nextInt(gc.getWidth()), -50));
			 } else elapsedtime += delta;  
		 for(MenuPiece mp:p){
			 mp.update(delta);
		 }
		 if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			 game.enterState(1);
		 }
		start.update(gc);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		for(MenuPiece mp:p){
			mp.render();
		}
		//g.drawString("Press Enter to Start",gc.getWidth()/2-50, gc.getHeight()/2);
		start.render(g);
	}

	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
		public void enter(GameContainer container, StateBasedGame game) throws SlickException {
			// TODO Auto-generated method stub
			super.enter(container, game);
			container.getGraphics().setBackground(Color.gray);
		}
}

class MenuPiece extends Image{
	static Random rand=new Random();
	 float x,y,rot=0;
	 public MenuPiece(int x, int y) {
	super(ChessSheet.getPiece(genTeam(), genPiece()).getScaledCopy(1.5f));
	this.x=x;
	this.y=y;
	
	
		// TODO Auto-generated constructor stub
	}
	 void update(int delta){
		 y+=delta*0.2;
		 rot+=delta*0.2;
	 }
	 void render(){
		
		draw(x, y);
		setRotation(rot);
	 }
	 static Players genTeam(){
		 if(rand.nextBoolean()){
			 return Players.Black;
		 }else return Players.White;
		 
	 }
	 static Pieces genPiece(){
		return Pieces.values()[rand.nextInt(6)];
	
}
	 
	 }




