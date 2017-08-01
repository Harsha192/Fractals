/*
 Author 		: H.R.H.G. Kosala (E/13/192)
 Project 		: Fractals
 Last Modified	: 04.09.2016
 (harshagayan8@gmail.com)
*/

public class Fractal{
	public static void main(String[] args) throws Exception {
		
		//width and height of the canvas
		int WIDTH = 800;
        int HEIGHT = 800;
		
		//check the number of arguments provide
		if(args[0].equals("Mandelbrot") && args.length==6){
			
			String setName = args[0];
			double realNeg = Double.parseDouble(args[1]);
			double realPos = Double.parseDouble(args[2]);
			double cmplxNeg = Double.parseDouble(args[3]);
			double cmplxPos = Double.parseDouble(args[4]);
			int max = Integer.parseInt(args[5]);
			
			Mandalbrot mb = new Mandalbrot(WIDTH,HEIGHT,realNeg,realPos,cmplxNeg,cmplxPos,max);
			
		}else if(args[0].equals("Julia") && args.length==4){
			
			String setName = args[0];
			double cReal = Double.parseDouble(args[1]);
			double cCmplx = Double.parseDouble(args[2]);
			int max = Integer.parseInt(args[3]);
			
			JuliaSet js = new JuliaSet(WIDTH,HEIGHT,setName,cReal,cCmplx,max);
			
		}else if(args[0].equals("Mandelbrot")){
			
			if(args.length==1){
				String setName = args[0];
				Mandalbrot mb = new Mandalbrot(WIDTH,HEIGHT);
			}else if(args.length==5){
				String setName = args[0];
				double realNeg = Double.parseDouble(args[1]);
				double realPos = Double.parseDouble(args[2]);
				double cmplxNeg = Double.parseDouble(args[3]);
				double cmplxPos = Double.parseDouble(args[4]);
				
				Mandalbrot mb = new Mandalbrot(WIDTH,HEIGHT,realNeg,realPos,cmplxNeg,cmplxPos);
				
			}
			
		}else if(args[0].equals("Julia")){
			
			if(args.length==1){
				String setName = args[0];
				JuliaSet js = new JuliaSet(WIDTH,HEIGHT);
			}else if(args.length==3){
				String setName = args[0];
				double cReal = Double.parseDouble(args[1]);
				double cCmplx = Double.parseDouble(args[2]);
				JuliaSet js = new JuliaSet(WIDTH,HEIGHT,cReal,cCmplx);
			}else{
				System.out.println("Wrong arguments");
			}
			
		}else{
			System.out.println("Wrong arguments");
		}
	}
	
}