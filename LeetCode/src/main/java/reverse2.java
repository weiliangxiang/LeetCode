public class reverse2 {
    public static void main(String[] args) {
        /*
        * 需求：在给定的字符串中，反转中文，英文单词不反转
        * 给定字符串：由于业务需求，开发决定部署一个redis高可用方案codis
        * 输出     ：codis案方用可高redis个一署部定决发开，求需物业于由
        * */
        System.out.println(ChinaRes("由于业务需求，开发决定部署一个redis高可用方案codis"));
    }
    public static String ChinaRes(String string) {
        String res = "";//res变量用于接收反转的字符
        StringBuffer sb = new StringBuffer();
        sb.append(string);
        for (int i = sb.length() - 1; i >= 0; ) {//反向输出
            if ((sb.charAt(i) + "").getBytes().length == 1) {//单词的开始位置
                for (int j = i; j >= 0; j--) {
                    if ((sb.charAt(j) + "").getBytes().length != 1) {//单词的结束位置
                        for (int k = j + 1; k <= i; k++) {//循环单词输出
                            res += sb.charAt(k);
                            if (k == i) {sb.delete(j + 1, k);}//如果是单词最后一个字符，在sb中删除单词
                        }
                        i = j + 1;//新的循环从sb的最大索引开始
                        break;//从单词的开始遇到不是单词的就不再循环
                    }
                }
            } else {res += sb.charAt(i);}
            i--;//每次--
        }
        return res;
    }
}
