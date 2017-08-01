import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

/*
* JuliaSet.java class map the Canvas points to the complex plane 
*/
public class JuliaSet extends Draw{
    
	String setName ;
    double cReal = -0.4;
    double cCmplx = 0.6;
	int max = 1000;
	int WIDTH;
    int HEIGHT;
	
	//Constructor with 0 arguments
	public JuliaSet(int WIDTH,int HEIGHT){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		
		try{
			this.setCmplxPlane();
		}catch(Exception e){
				
		}
	}
	
	
	//Constructor with 2 arguments
	public JuliaSet(int WIDTH,int HEIGHT,double cReal, double cCmplx){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.cReal = cReal;
		this.cCmplx = cCmplx;
		
		try{
			this.setCmplxPlane();
		}catch(Exception e){
				
		}
	}
	
		
	//Constructor with 3 arguments
	public JuliaSet(int WIDTH,int HEIGHT,String setName, double cReal, double cCmplx, int max){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.setName = setName;
		this.cReal = cReal;
		this.cCmplx = cCmplx;
		this.max = max;
		try{
			this.setCmplxPlane();
		}catch(Exception e){
				
		}
	}
		
		
	void setCmplxPlane(){
			
        BufferedImage image = new BufferedImage(this.WIDTH,this.HEIGHT,BufferedImage.TYPE_INT_RGB);
	
       
        for (int i=0;i<WIDTH;i++){
            for (int j=0;j<HEIGHT;j++){
				double real = (i-400)/400.0;  //Calculate the real part of the complex number
				double cmplx = (400.0-j)/400.0; //Calculate the imaginary part of the complex number
				double x = real; 
				double y = cmplx;
				int iteration = 0;
				while(x*x + y*y <4 && iteration<max){
					double xNew = x*x-y*y+cReal;  //real part of the Z
                    double yNew = 2*x*y +cCmplx;  //imaginary part of the Z
                    x = xNew;
                    y = yNew;
                    iteration++;
					
					//Set color by checking iteration number
					if (iteration<10) {
						setColor(image,i,j,Color.yellow.getRGB()); //Inherited method from Draw class
					}else if(iteration<25) {
						setColor(image,i,j,Color.orange.getRGB()); //Inherited method from Draw class
					}else if(iteration<50){
						setColor(image,i,j,Color.black.getRGB()); //Inherited method from Draw class
					}else if(iteration<100){
						setColor(image,i,j,Color.MAGENTA.getRGB()); //Inherited method from Draw class
					}else if(iteration<200){
						setColor(image,i,j,Color.cyan.getRGB());
					}else if(iteration<300){
						setColor(image,i,j,Color.LIGHT_GRAY.getRGB());
					}else if(iteration<400){
						setColor(image,i,j,Color.PINK.getRGB());
					}else if(iteration<500){
						setColor(image,i,j,Color.RED.getRGB());
					}else if(iteration<600){
						setColor(image,i,j,Color.yellow.getRGB());
					}else if(iteration<700){
						setColor(image,i,j,Color.RED.getRGB());
					}else if(iteration<800){
						setColor(image,i,j,Color.orange.getRGB());
					}else if(iteration<900){
						setColor(image,i,j,Color.MAGENTA.getRGB());
					}else if(iteration<=950){
						setColor(image,i,j,Color.LIGHT_GRAY.getRGB());
					}else{
						setColor(image,i,j,Color.RED.getRGB());
					}
				}
				
			}
		}
		//Inherited method from Draw class
		drawJFrame(image,WIDTH,HEIGHT,"Julia Set");
	}
}