import java.util.List;
import java.util.ArrayList;

public class mergeSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(20);
        list.add(5);
        list.add(1);
        list.add(87);
        list.add(125);
        list.add(2);
        list.add(100);
        list.add(50);
        System.out.println(list);
        List<Integer> sortedList = sort(list);
        System.out.println(sortedList);
    }
    public static List<Integer> sort(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }
        int middleIndex = Math.floorDiv(list.size(), 2);
        List<Integer> sublistLeft = sort(list.subList(0, middleIndex));
        List<Integer> sublistRight = sort(list.subList(middleIndex, list.size()));
        list =  merge(sublistLeft,sublistRight);
        return list;
    }
    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        Integer pointer1 = 0;
        Integer pointer2 = 0;
        while (pointer1 < list1.size() && pointer2 < list2.size()) {
            if (list1.get(pointer1) <= list2.get(pointer2)) {
                mergedList.add(list1.get(pointer1));
                pointer1 = pointer1 + 1;
            } else {
                mergedList.add(list2.get(pointer2));
                pointer2 = pointer2 + 1;
            }
        }
        if (pointer1 == list1.size()) {
            for (int i = pointer2; i < list2.size(); i++ ) {
                mergedList.add(list2.get(i));
            }
        } else {
            for (int i = pointer1; i < list1.size(); i++ ) {
                mergedList.add(list1.get(i));
            }
        }
        return mergedList;
    }
}