import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    /*
    * 给定 nums = [2, 7, 11, 15], target = 9
      因为 nums[0] + nums[1] = 2 + 7 = 9
       所以返回 [0, 1]
    * */
    public static void main(String[] args) {
        /*
        int target=9;
        int[] numbers =new int[]{0,1,2,3,4,5,6,7,8,9};
        HashMap<Integer,Integer> map=twoSumWay(numbers,target);
        for (Integer key:map.keySet()){
            Integer value=map.get(key);
            System.out.println(key+"+"+value+"="+target);
        }*/
        int target=9;
        int[] numbers =new int[]{0,1,2,3,4,5,6,7,8,9};
        HashMap<Integer,Integer> map=twoSumHash(numbers,target);
        for (Integer key:map.keySet()){
            Integer value=map.get(key);
            System.out.println(key+"+"+value+"="+target);
        }

    }
    public static HashMap<Integer,Integer> twoSumWay(int[] number, int target){
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i <number.length ; i++) {
            for (int j = i+1; j <number.length ; j++) {
                if (number[i]+number[j]==target){
                    map.put(number[i],number[j]);
                }
            }
        }
        return map;
    };
    public static HashMap<Integer,Integer> twoSumHash(int[] num,int target2){
        HashMap<Integer,Integer> ParentMap =new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> outMap =new HashMap<Integer, Integer>();
        for (int i = 0; i <num.length ; i++) {
            int temp=target2-num[i];
            if(ParentMap.containsKey(temp)){
                outMap.put(temp,i);
            }else{
                ParentMap.put(num[i],i);
            }
        }
        return outMap;
    }
}
