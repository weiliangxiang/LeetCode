public class sanjiaoxing {
    public static void main(String[] args) {
        daosan();
    }
    public static void zhengsan(){
        for (int i = 1; i <=7 ; i++) {
            for (int j = 1; j <=7-i ; j++) {
                System.out.print(" ");
            }
            for (int m = 1; m <=i*2-1 ; m++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void daosan(){
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <i ; j++) {
                System.out.print(" ");
            }
            for (int m = 0; m<2*(5-i)-1; m++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
