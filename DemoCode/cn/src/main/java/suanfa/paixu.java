package suanfa;

public class paixu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score= {67, 69, 75, 87, 89, 90, 99, 100};
		int length=score.length;
		for (int i = 0; i < score.length-1; i++) {//控制趟数
			for(int j=0;j<score.length-i-1;i++) {//控制循环
				if (score[i]>score[i+1]) {
					int temp;
					temp=score[i];
					score[i]=score[i+1];
					score[i+1]=temp;
				}
			}
		
		}
		System.out.println("排序后的数组为:");
		for (int i : score) {
			System.out.print(i+" ");
		}

	}

}
