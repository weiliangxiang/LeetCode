public class wordReverse {
    public static void main(String[] args) {
        String string=wordRever("I Love Your name");
        System.out.println(string);
    }
    public static String wordRever(String string){
        String res="";
        String[] words =string.split(" ");
        for (int i = words.length-1; i >=0; i--) {
            if (i==0) {
                res += words[i];
            }else{
                res += words[i] + " ";
            }
        }
        return res;
    }
}
