package visualization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphicsUtil {
	
	public static BufferedImage loadImage(String filename) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File ("res/" + filename));
		} catch(IOException e) {
			System.out.println("Unable to load sprite sheet");
			System.exit(0);
		}
		return image;
	}
	
	public static BufferedImage[] getSpriteArray(BufferedImage image, int columns, int rows, int tileSize){
		int index = 0;
		BufferedImage[] output = new BufferedImage[columns * rows];
		for(int col = 1; col <=columns; ++col) {
			for(int row = 1; row <=rows; ++row) {
				BufferedImage sprite = extractSprite(image, col, row, tileSize);
				output[index] = sprite;
				++index;
			}
		}
		return output;
	} 
	
	public static BufferedImage extractSprite(BufferedImage image, int col, int row, int tileSize) {
		return image.getSubimage((row*tileSize) - tileSize, (col*tileSize) - tileSize, tileSize, tileSize);
	}
}
