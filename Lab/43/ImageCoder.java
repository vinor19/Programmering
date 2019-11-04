public class ImageCoder{

	public Image image;

	public static void main(String[] args){
	//Image test = new Image("uknown.png");
	Image test = new Image(700,700);
	//addRectangle(test, 0, 0, 600, 600, -1, -1, -1);
	//test.display();
	addCircle(test, 300, 300, 100, 255, 255, 255);
	addCircle(test, 500, 300, 100, 255, 255, 255);
	addCircle(test, 400, 400, 150,  255, 255, 255);
	addCircle(test, 350, 350, 25, 0, 0, 0);
	addCircle(test, 450, 350, 25, 0, 0, 0);
	addCircle(test, 350, 350, 24,  255, 255, 255);
	addCircle(test, 450, 350, 24,  255, 255, 255);
	addCircle(test, 350, 350, 10, 0, 0, 0);
	addCircle(test, 450, 350, 10, 0, 0, 0);
	addRectangle(test, 325, 475, 150, 20, 0, 0, 0);
	test.setPixel(0,0,255,255,255);
	test.display();
	encrypt(test, "PerfektDokumentation");
	test.display();
	decrypt(test, "PerfektDokumentation");
	
	test.display();
	}
	
//Draws a rectangle of given size in another image, that starts with the upper left cornor at x,y
	public static void addRectangle(Image image, int x, int y, int width, int height, int red, int green, int blue){
		int minX=Math.max(x,0);
		int minY=Math.max(y,0);
		int widthMax=Math.min(x+width,image.width());
		int heightMax=Math.min(y+height,image.height());
		for(int i = minY;i<heightMax;i++)
			for(int j = minX; j < widthMax; j++)
				image.setPixel(j,i,red,green,blue);
	}
	
//Draws a circle, with a given center point and radius
	public static void addCircle(Image image, int x, int y, int radius, int red, int green, int blue){
		for(int i = radius-y;i<radius+y;i++)
			for(int j = radius-x; j < radius+x; j++)
				if((i-y)*(i-y)+(j-x)*(j-x)<=radius*radius)
					image.setPixel(j,i,red,green,blue);
	}
	
//Ecrypts the image
	public static void encrypt(Image image, String key){
		int oldRed = 0, oldBlue = 0, oldGreen = 0;
		int k = 0;
		for(int i = 0; i<image.height();i++)
			for(int j = 0; j<image.width();j++){
				image.setPixel(j,i,oldRed+image.red(j,i)+key.charAt(k%key.length()),image.green(j,i),image.blue(j,i));
				k=k+1;
				image.setPixel(j,i,image.red(j,i),oldGreen+image.green(j,i)+key.charAt(k%key.length()),image.blue(j,i));
				k=k+1;
				image.setPixel(j,i,image.red(j,i),image.green(j,i),oldBlue+image.blue(j,i)+key.charAt(k%key.length()));
				k=k+1;
				oldRed=image.red(j,i);
				oldBlue=image.blue(j,i);
				oldGreen=image.green(j,i);
			}
	}
	
//decrypts the image
	public static void decrypt(Image image, String key){
		int oldRed = 0, oldBlue = 0, oldGreen = 0, currentRed, currentGreen, currentBlue;
		int k = 0;
		for(int i = 0; image.height()>i;i++)
			for(int j = 0; image.width()>j;j++){
				currentRed=image.red(j,i);
				currentBlue=image.blue(j,i);
				currentGreen=image.green(j,i);
				image.setPixel(j,i,image.red(j,i)-key.charAt(k%key.length())-oldRed,image.green(j,i),image.blue(j,i));
				k=k+1;
				image.setPixel(j,i,image.red(j,i),image.green(j,i)-key.charAt(k%key.length())-oldGreen,image.blue(j,i));
				k=k+1;
				image.setPixel(j,i,image.red(j,i),image.green(j,i),image.blue(j,i)-key.charAt(k%key.length())-oldBlue);
				k=k+1;
				oldRed=currentRed;
				oldBlue=currentBlue;
				oldGreen=currentGreen;
			}
	}
}