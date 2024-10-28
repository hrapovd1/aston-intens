package task1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var aList = new ArrayList<String>();

        aList.add(0, "n");
        aList.add(1, "n1");
        aList.add(2, "n2");
        aList.add(3, "n2");

        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("add the same index");
        aList.add(2, "n3");
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("remove 2 element");
        aList.remove(2);
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("remove n2 element");
        aList.remove("n2");
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("add elements");
        aList.add(4, "a");
        aList.add(5, "y");
        aList.add(6, "a1");
        aList.add(7, "b");
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("sort");
        aList.sort(Comparator.comparing(String::toString));
        for(int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }
    }
}
