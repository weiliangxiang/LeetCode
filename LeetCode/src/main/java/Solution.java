class Solution {
    public String reverseWords(String s) {
        /*
        * 输入: "the sky is blue"
        * 输出: "blue is sky the"
        * */
        String res="";
        String[] words=s.split(" ");
        for (int i = 0; i <words.length-1 ; i++) {
            System.out.println();
            if (i!=words.length-1){
                res+=words[i]+" ";
            }else {
                res+=words[i];
            }
        }
        return res;

    }
}