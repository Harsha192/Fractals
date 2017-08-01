import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Draw{
	
	//setColor method set the color to the mapping point
	void setColor(BufferedImage image, int i, int j,int color){
		image.setRGB(i,j,color);
	}
	
	//drawJFrame method to create JFrame to hold the Specific fractal image
	void drawJFrame(BufferedImage image, int WIDTH, int HEIGHT,String name){
		try{
			ImageIO.write(image,"png",new File(("Fractal.png")));
			JFrame jf = new JFrame(name);
			jf.setSize(WIDTH, HEIGHT);
			jf.add(new JLabel(new ImageIcon("Fractal.png")));
			jf.setVisible(true);
		}catch(Exception e){
			System.out.println("Error.");
		}	
	}
	
	
}