package suanfa;

public class charjiequ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st2=cut("hello world");
		System.out.println(st2);

	}
	public static String cut(String string) {
		return string.substring(1, 4);//包含头不包含尾
	}

}
