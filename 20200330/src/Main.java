import java.util.*;
public class Main {

    /*链接：https://www.nowcoder.com/questionTerminal/00ffd656b9604d1998e966d555005a4b
来源：牛客网

1、中文大写金额数字前应标明“人民币”字样。
中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）

2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，
如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）

3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，
中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] sts = str.split("\\.");
            String s = sts[0];
            StringBuilder sb = new StringBuilder("人民币");
            for (int i = s.length() - 1, j = 0; i >= 0; j++, i--) {
                if (s.charAt(j) != 0) {
                    if (j >= 3 && i % 4 == 0 && s.charAt(j - 1) == '0' && s.charAt(j - 2) == '0') {
                        sb.append("零");
                    }
                    if (s.charAt(j) == '1' && i % 4 - 1 == 0) {
                    } else {
                        sb.append(Num(s.charAt(j)));
                    }
                }
                if (i > 0) {
                    if (i % 8 == 0 && i >= 8) {
                        sb.append("亿");
                    } else if (i % 4 == 0 && i % 8 != '0') {
                        sb.append("万");
                    } else if (i % 4 == 3 && s.charAt(j) != '0') {
                        sb.append("仟");
                        if (s.charAt(j + 1) == '0' && s.charAt(j + 2) != '0') {
                            sb.append("零");
                        }
                    } else if (i % 4 == 2 && s.charAt(j) != '0') {
                        sb.append("佰");
                        if (s.charAt(j + 1) == 0) {
                            sb.append("零");
                        }
                    } else if (i % 4 == 1 && s.charAt(j) != '0') {
                        sb.append("拾");
                    }
                }

            }
            if (s.charAt(0) != '0') {
                sb.append("元");
            }
            if (sts[1].equals("00")) {
                sb.append("整");
            } else {
                if (sts[1].charAt(0) == '0') {
                    sb.append(Num(sts[1].charAt(1)));
                    sb.append("分");

                }
                if (sts[1].charAt(1) == '0') {
                    sb.append(Num(sts[1].charAt(0)));
                    sb.append("角");

                }
                if (sts[1].charAt(0) !='0' && sts[1].charAt(1) != '0') {
                    sb.append(Num(sts[1].charAt(0)));
                    sb.append("角");
                    sb.append(Num(sts[1].charAt(1)));
                    sb.append("分");
                }
            }
            System.out.println(sb);
        }
    }
        public static String Num ( char c){
            if (c == '1') {
                return "壹";
            }
            if (c == '2') {
                return "贰";
            }
            if (c == '3') {
                return "叁";
            }
            if (c == '4') {
                return "肆";
            }
            if (c == '5') {
                return "伍";
            }
            if (c == '6') {
                return "陆";
            }
            if (c == '7') {
                return "柒";
            }
            if (c == '8') {
                return "捌";
            }
            if (c == '9') {
                return "玖";
            }
            return null;
        }


        public static void main1 (String[]args){
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                int n = in.nextInt();
                int[] stu = new int[n];
                int[] score = new int[n];
                for (int i = 0; i < stu.length; i++) {
                    stu[i] = in.nextInt();
                }
                for (int j = 0; j < score.length; j++) {
                    score[j] = in.nextInt();
                }
                double[] jidian = new double[n];
                double[] scojidian = new double[n];
                for (int i = 0; i < n; i++) {
                    if (score[i] >= 90 && score[i] <= 100) {
                        jidian[i] = 4.0;
                    } else if (score[i] >= 85 && score[i] <= 89) {
                        jidian[i] = 3.7;
                    } else if (score[i] >= 82 && score[i] <= 84) {
                        jidian[i] = 3.3;
                    } else if (score[i] >= 78 && score[i] <= 81) {
                        jidian[i] = 3.0;
                    } else if (score[i] >= 75 && score[i] <= 77) {
                        jidian[i] = 2.7;
                    } else if (score[i] >= 72 && score[i] <= 74) {
                        jidian[i] = 2.3;
                    } else if (score[i] >= 68 && score[i] <= 71) {
                        jidian[i] = 2.0;
                    } else if (score[i] >= 64 && score[i] <= 67) {
                        jidian[i] = 1.5;
                    } else if (score[i] >= 60 && score[i] <= 63) {
                        jidian[i] = 1.0;
                    } else if (score[i] < 60) {
                        jidian[i] = 0.1;
                    }
                    scojidian[i] = jidian[i] * stu[i];
                }
                double count = 0.0;
                int xuefen = 0;
                for (int i = 0; i < n; i++) {
                    xuefen += stu[i];
                    count += scojidian[i];
                }
                double gpa = count / xuefen;
                System.out.printf("%.2f", gpa);
            }
        }

}