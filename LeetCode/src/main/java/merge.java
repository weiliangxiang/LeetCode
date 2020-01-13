import java.util.ArrayList;
import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] num1=new int[]{7,1,2,3};
        int[] num2=new int[]{4,5,6,0};
        int[] merge =mergeArray(num1,num2);
        for (int i = 0; i <merge.length ; i++) {
            System.out.println(merge[i]);
        }
        /*int[] pai =paixu(num1);
        for (int i = 0; i <num1.length ; i++) {
            System.out.println(num1[i]);
        }
        System.out.println();*/
    }
    public static int[] mergeArray(int[] numbers1,int[] numbers2){
        ArrayList<Integer> list =new ArrayList();
        int[] mergeArr =new int[numbers1.length+numbers2.length];
        for (int num1:numbers1){
            list.add(num1);
        }
        for (int num2:numbers2){
            list.add(num2);
        }
        for (int i = 0; i <list.size() ; i++) {
            mergeArr[i]=list.get(i);
        }
        int[] pMergeArr =paixu(mergeArr);
        return pMergeArr;
    }
    public static int[] paixu(int[] num){
        int[] newArr=new int[num.length];
        for (int i = 0; i <num.length-1 ; i++) {
            for (int j = 0; j <num.length-i-1 ; j++) {
                if (num[j]>num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i <num.length ; i++) {
            newArr =new int[]{num[i]};
        }
        return newArr;
    }
}
