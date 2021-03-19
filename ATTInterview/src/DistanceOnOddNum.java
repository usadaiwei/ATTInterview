import java.util.ArrayList;
import java.util.List;

/* Time complexity: On
 */
public class DistanceOnOddNum {

    public static List<Integer> distanceOddNum(List<Integer> list){
        List<Integer> odd = new ArrayList<>();
        int lengthOfList = list.size();
        for (int i=0; i<list.size(); i++){
            if (list.get(i) % 2 != 0) {
                odd.add(list.get(i));
                list.remove(i);
            }
        }

        int lengthOfOdd = odd.size();
        int count = lengthOfList / (lengthOfOdd - 1);
        list.add(0, odd.get(0));
        list.add(odd.get(lengthOfOdd - 1));
        odd.remove(lengthOfOdd - 1);
        odd.remove(0);

        for (int i=1; i<list.size()-1; i++) {
            if (i % count == 0) {
                list.add(i-1, odd.get(0));
                odd.remove(0);
            }
        }
        return list;
    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(8);

        List<Integer> ans = distanceOddNum(list);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
