import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static List<List<Integer>> subSet(ArrayList<Integer> left,ArrayList<Integer> right){
        if(right.size() == 0 ){
            System.err.println(left);
            List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
            res.add(left);
            return res;
        }

        Integer element = right.get(0);
        ArrayList<Integer> rightTemp = right;
        ArrayList<Integer> leftTemp = left;
        leftTemp.add(element);
        rightTemp.remove(element);
        List<List<Integer>> r1 = subSet(leftTemp, rightTemp);
        leftTemp.remove(element);
        List<List<Integer>> r2 = subSet(leftTemp, rightTemp);
        System.out.println(left);
        r1.addAll(r2);
        return r1;
    }

    public static void main(String[] args) {
        System.out.println(subSet(new ArrayList<>(), new ArrayList<>(List.of(1,2,3,4,5))));
    }
}
