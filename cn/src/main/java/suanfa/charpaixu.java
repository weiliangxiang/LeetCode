package suanfa;

import java.nio.channels.SelectableChannel;

public class charpaixu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st1=paixu("dcba");
		System.out.println(st1);

	}
	public static String paixu(String string) {
		//将字符串转换成char类型的数组
		char[] ch=string.toCharArray();
		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<i;j++) {
				if (ch[i]<ch[j]) {
					char temp;
					temp=ch[i];
					ch[i]=ch[j];
					ch[j]=temp;
				}
			}
		}
		//将字符数组转换成字符串
		String s1=new String(ch);
		return s1;
		
	}

}
