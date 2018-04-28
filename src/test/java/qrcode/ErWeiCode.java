package qrcode;

public class ErWeiCode {
     public static void main(String[] args) {
		String data="一个程序员的微信公众账号";
		
		Encode.encode(data, "J:/牛彤彤.JPG");
		
		Decode.decode("J:/牛彤彤.JPG");
		
		
	}
}
