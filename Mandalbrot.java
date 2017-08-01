import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
/*
* Mandalbrot.java class map the Canvas points to the complex plane 
*/
public class Mandalbrot extends Draw {
    
	//set defaults values
    double realNeg = -1;
    double realPos = 1;
    double cmplxNeg = -1;
    double cmplxPos = 1;
    int max = 1000;
	
    int WIDTH;
    int HEIGHT;
	
		//constructor for 0 arguments
		public Mandalbrot(int WIDTH, int HEIGHT){
			this.WIDTH = WIDTH;
			this.HEIGHT = HEIGHT;
			
			try{
				this.setCmplxPlane();
			}catch(Exception e){
				
			}
			
		}
		
		//Constructor for 4 arguments
		public Mandalbrot(int WIDTH, int HEIGHT,double realNeg,double realPos,double cmplxNeg, double cmplxPos){
			this.WIDTH = WIDTH;
			this.HEIGHT = HEIGHT;
			this.realNeg = realNeg;
			this.realPos = realPos;
			this.cmplxNeg = cmplxNeg;
			this.cmplxPos = cmplxPos;
		
			
			try{
				this.setCmplxPlane();
			}catch(Exception e){
				
			}
		}
		
		
		//Constructor for 5 arguments
		public Mandalbrot(int WIDTH, int HEIGHT,double realNeg,double realPos,double cmplxNeg, double cmplxPos,int max){
			this.WIDTH = WIDTH;
			this.HEIGHT = HEIGHT;
			this.realNeg = realNeg;
			this.realPos = realPos;
			this.cmplxNeg = cmplxNeg;
			this.cmplxPos = cmplxPos;
			this.max = max;
			
			try{
				this.setCmplxPlane();
			}catch(Exception e){
				
			}
		}
		
		void setCmplxPlane(){

			BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        
			for (int i=0;i<HEIGHT;i++){
				for (int j=0;j<WIDTH;j++){
                
					double real = (realPos-realNeg)*i/800 + realNeg; //Calculate the real part of the complex number
					double cmplx = (cmplxNeg-cmplxPos)*j/800 + cmplxPos; //Calculate the imaginary part of the complex number
					
					double x=0, y=0;
					int iteration = 0;
					
					while (x*x + y*y <4 && iteration<max){
						double xNew = x*x-y*y+real; //real part of the Z
						double yNew = 2*x*y +cmplx; //imaginary part of the Z
						x = xNew;
						y = yNew;
						iteration++;
					
						if (iteration<10) {
							setColor(image,i,j,Color.yellow.getRGB()); //Inherited method from Draw class
						}else if(iteration<25){
							setColor(image,i,j,Color.cyan.getRGB()); //Inherited method from Draw class
						}else if(iteration<100){
							setColor(image,i,j,Color.orange.getRGB());
						}else if(iteration<500){
							setColor(image,i,j,Color.MAGENTA.getRGB());
						}else if(iteration<600){
							setColor(image,i,j,Color.LIGHT_GRAY.getRGB());
						}else{
							setColor(image,i,j,Color.black.getRGB());
						}
					}
				}
			}
			
			drawJFrame(image,WIDTH,HEIGHT,"Mandalbrot Set"); //Inherited method from Draw class
		}
}
