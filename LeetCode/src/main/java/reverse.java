public class reverse {
    public static void main(String[] args) {
        System.out.println(reverseInt2(321));
    }
    public static int reverseInt(int num){
       String strings=String.valueOf(num);
       char[] chars=strings.toCharArray();
       String out="";
       Integer integer;
        for (int i = chars.length-1; i >=0 ; i--) {
            out+=chars[i];
        }
        integer=new Integer(out);
        int i =integer.intValue();
        return i;
    }
    public static int reverseInt2(int num){
       int rev=0;
      while (num!=0){
          int temp=num%10;
          num=num/10;
          rev=rev*10+temp;//取到原数字最后一个数字后，添加到新数字的尾部
      }
      return rev;
    }
}
