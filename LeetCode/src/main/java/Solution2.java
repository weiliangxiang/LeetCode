public class Solution2 {
    public static void main(String[] args) {
        String string=test("a good  example");
        System.out.println(string);
    }
    public static String test(String s){
        String res="";
        String temp=s.trim();
        String[] words=temp.split(" ");
        for (int i = words.length-1; i >=0 ; i--) {
            if (i!=0&&!words[i].equals("")){
                res+=words[i].trim()+" ";
            }else {
                res+=words[i];
            }
        }
        return res;
    }
}
