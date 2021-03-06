import java.util.*;

public class Main {

    //查找兄弟单词
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            List<String> list = new ArrayList<>();
            int n = in.nextInt();
            String[] dict = new String[n];
            for(int i=0;i<n;i++){
                dict[i] = in.next();
            }
            String src = in.next();
            int brother = in.nextInt();
            Arrays.sort(dict);
            for(String str:dict){
                if(isbrother(src,str)){
                    list.add(str);
                }
            }
            System.out.println(list.size());
            if(brother<=list.size() && list.size()>0){
                System.out.println(list.get(brother-1));
            }
        }
    }


    public static boolean isbrother(String src,String str){
        if(src.equals(str) ) {
            return false;
        }
        if(src.length()!=str.length()){
            return false;
        }
        char[] target = src.toCharArray();
        char[] strArray = str.toCharArray();
        Arrays.sort(target);
        Arrays.sort(strArray);
        for(int i=0;i<target.length;i++){
            if(target[i]!=strArray[i]){
                return false;
            }
        }
        return true;
    }

    //乒乓球筐  牛客
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String A = in.nextLine();
            String[]B = A.split(" ");
            //在s1中找s2的字符，若找到就将s1中s2的字符删掉，继续查找s2的下一个字符，
            //若找不到，则直接返回“No”,若s2中的字符在s1中全都能找到，则返回“Yes”。
            List<Character>list1 = new ArrayList<>();
            List<Character>list2 = new ArrayList<>();

            for(int i=0;i<B[0].length();i++){
                list1.add(B[0].charAt(i));
            }
            for(int i=0;i<B[1].length();i++){
                list2.add(B[1].charAt(i));
            }
            for(int i=0;i<list2.size();i++){
                if(list1.contains(list2.get(i))){
                    list1.remove(list1.get(list1.indexOf(list2.get(i))));
                    list2.remove(i);
                    i--;
                }
            }


            if(list2.size() == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}
