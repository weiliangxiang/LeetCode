import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class gongyueshu {
    public static void main(String[] args) {
        System.out.println(PrimeGCD(20,25));
        System.out.println(gongbeishu(25,25));
    }

    public static int gongyue(int m, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        for (int i = 2; i < m; i++) {// 16  6    2 8 4 4
            if (m % i == 0 && i != n) {
                map.put(i, m / i);
            }
        }
        return n;
    }

    //方法2
    public static int PrimeGCD(int m, int n) {
        int result = 1;
        Set<Integer> set1 = getFactor(m);
        Set<Integer> set2 = getFactor(n);
        // 取交集
        set1.retainAll(set2);
        if (set1.size()>0){
            // 取最大
            result = Collections.max(set1);
        }
        return result;
    }

    private static Set<Integer> getFactor(int m) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 2; i <= m; i++) {
            if (m%i==0) {
                set.add(i);
            }
        }
        return set;
    }
    public static int gongbeishu(int m,int n){
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        System.out.println("m="+m+" n="+n);
        Set<Integer> set =new HashSet<Integer>();
        for (int i = n; i <=m*n; i++) {
            if (i%m==0&&i%n==0){
                set.add(i);
            }
        }
        Integer result =Collections.min(set);
        return result;
    }
}
