package chess.Pieces;

import java.awt.image.BufferedImage;

public class SpriteSheet {
private BufferedImage sheet;
public SpriteSheet(BufferedImage sheet){		//Oh sheeeeeettttt
	this.sheet = sheet;
}
public BufferedImage crop(int coloumn, int row, int width, int height){
	return sheet.getSubimage(coloumn * 2, row * 7, width, height);
	
}
}
