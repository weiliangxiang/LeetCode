public class isPalindrome {
    public static void main(String[] args) {

        System.out.println(isPalind(321));
    }
    public static boolean isPalind(int num){
        int parentNum=num;
        Boolean flag=false;
        int rev=0;
        while (num!=0){
            int temp=num%10;//
            num=num/10;
            rev=rev*10+temp;
        }
        System.out.println(parentNum+":"+rev);
       if (parentNum==rev){
           flag=true;
       }
       return flag;
    }
}
