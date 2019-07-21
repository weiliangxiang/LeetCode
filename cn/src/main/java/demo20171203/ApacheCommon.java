package demo20171203;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.binary.Base64;

public class ApacheCommon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show("weiliangxiang的md5加密为:"+MD5("weiliangxiang"));
		show("weiliangxiang的sha256Hex加密为:"+sha256Hex("weiliangxiang"));
		show("weiliangxiang的Base64加密为:"+base64Encode("weiliangxiang"));

	}
	public static String MD5(String string) {
		return DigestUtils.md5Hex(string).toUpperCase();
	}
	public static String sha256Hex(String string) {
		return DigestUtils.sha256Hex(string);
	}
	 //base64  
    public static String base64Encode(String data) {  
        return Base64.encodeBase64String(data.getBytes());  
    }
	public static void show(Object object) {
		System.out.println(object);
	}

}
