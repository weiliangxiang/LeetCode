package suanfa;

/*【程序2】   题目：判断101-200之间有多少个素数，并输出所有素数。
 * 
 * */
public class sushu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prime(101, 200);

	}

	public static void prime(int a, int b) {
		
		for (int m = a; m <= b; m++) {
			Boolean flag = true;
			for (int n = 2; n < m; n++) {
				if (m % n == 0) {
					flag = false;
					break;
				}

			}
			if (flag) {//if(flag==true)
				System.out.println(m);
			}

		}

	}
}
