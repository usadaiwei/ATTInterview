import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Time complexity: nlogn because of sorting
   Space complexity: On because of the use of another list
 */
public class FunnySort {

    public static List<Integer> funnySort(List<Integer> unsorted) {

        Collections.sort(unsorted);
        List<Integer> ans = new ArrayList<>();
        if (unsorted.get(0) == null)
            return unsorted;
        if (unsorted.size() >= 4) {
            for (int i = 0; i < unsorted.size()/4; i++) {
                ans.add(unsorted.get(unsorted.size() - 1));
                ans.add(unsorted.get(unsorted.size() - 2));
                ans.add(unsorted.get(0));
                ans.add(unsorted.get(1));
                unsorted.remove(unsorted.size() - 1);
                unsorted.remove(unsorted.size() - 1);
                unsorted.remove(0);
                unsorted.remove(0);
            }
        }
        if (unsorted.size() == 3) {
            ans.add(unsorted.get(2));
            ans.add(unsorted.get(1));
            ans.add(unsorted.get(0));
        } else if (unsorted.size() == 2) {
            ans.add(unsorted.get(1));
            ans.add(unsorted.get(0));
        } else if (unsorted.size() == 1) {
            ans.add(unsorted.get(0));
        }
        return ans;
    }

    public static void main(String[] args) {
        // 1, 7, 2, 3, 19, 5
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(19);
        list.add(5);

        List<Integer> ans = funnySort(list);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

}
