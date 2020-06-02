import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class TestDemo {
    public static void main(String[] args) {
        List<List<Integer>> ret = generate(5);
        System.out.print(ret);
    }

    public static List<List<Integer>> generate(int numsRow){
        List<List<Integer>> ret = new ArrayList<>();
        if(numsRow==0){
            return ret;
        }
        //重要一步
        List<Integer> list = new ArrayList<>();
        ret.add(list);

        ret.get(0).add(1);
        for(int i=1;i<numsRow;i++){
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            List<Integer> prevRow = ret.get(i-1);
            for(int j=1;j<i;j++){
                int num = prevRow.get(j)+prevRow.get(j-1);
                curRow.add(num);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }

}
