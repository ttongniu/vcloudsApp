package qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class J2SEImageGucas implements QRCodeImage {
   private BufferedImage image;
   public J2SEImageGucas(BufferedImage image){
	   this.image=image;
   }
	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight();
	}

	public int getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return image.getRGB(x, y);
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth();
	}

}
