import java.util.*;

public class ReverseList {
    public static <T> void reverse(List<T> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> linkedList = new LinkedList<>(arrayList);

        reverse(arrayList);
        reverse(linkedList);

        System.out.println(arrayList);
        System.out.println(linkedList);
    }
}
