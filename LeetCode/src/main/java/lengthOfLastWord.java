import java.util.HashMap;

public class lengthOfLastWord {
    public static void main(String[] args) {
        HashMap<String,Integer> map=lengthOf("Hello World");
        for (String key:map.keySet()){
            Integer value =map.get(key);
            System.out.println("last World is:"+key);
            System.out.println("length of is: "+value);

        }
    }
    public static HashMap<String,Integer> lengthOf(String string){
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        String[] strings =string.split(" ");//Hello World
        int length =strings.length-1;
        String worlds =strings[length];
        char[] chars =worlds.toCharArray();
        map.put(worlds,chars.length);
        return map;
    }

}
