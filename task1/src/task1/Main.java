package task1;

import java.util.Comparator;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var aList = new ArrayList<String>();

        System.out.println("add first 4 elements");
        aList.add(0, "n");
        aList.add(1, "n1");
        aList.add(2, "n2");
        aList.add(3, "n2");

        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }

        System.out.println("add the same index");
        aList.add(2, "n3");
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }

        System.out.println("remove 2 element");
        aList.remove(2);
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }

        System.out.println("remove n2 element");
        aList.remove("n2");
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }

        System.out.println("add elements");
        aList.addAll(Arrays.asList("a", "y", "a1", "b"));
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }

        System.out.println("sort");
        aList.sort(Comparator.comparing(String::toString));
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }

        System.out.println("get 3 element: " + aList.get(3));
        System.out.println("array is empty?: " + aList.isEmpty());

        System.out.println("clear array");
        aList.clear();
        System.out.println("array size: " + aList.size());
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i) + "\t" + i);
        }
    }
}
