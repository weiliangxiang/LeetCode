package suanfa;
/*
 * 【程序3】   题目：打印出所有的 水仙花数 ，所谓 水仙花数 是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个 水仙花数 ，因为153=1的三次方＋5的三次方＋3的三次方
 * 100-999
 * 
 * */

public class shuixianhua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<1000;i++) {
			int baiwei=i/100;
			int shiwei=i%100/10;
			int gewei=i%10;
			if (baiwei*baiwei*baiwei+shiwei*shiwei*shiwei+gewei*gewei*gewei==i) {
				System.out.println(i);
			}
		}

	}
	

}
