package qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class Decode {
     public static String decode(String qrcodePicfilePath){
    	 System.out.println("开始解析二维码！！");
    	 /*读取二维码图像数据*/
    	 File imageFile =new File(qrcodePicfilePath);
	     BufferedImage image=null;
	     try {
			image=ImageIO.read(imageFile);
		} catch (Exception e) {
			System.out.println("读取二维码图片失败："+e.getMessage());
			return null;
		}
	     //解二维码
	     QRCodeDecoder decoder=new QRCodeDecoder();
	     String decodedData=new String(decoder.decode(new J2SEImageGucas(image)));
    	 System.out.println("解析内容如下："+decodedData);
	     return decodedData;
    	 
     }  
}
