package pro.sky.java.course2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        StringList stringList = new StringListImpl(10);

        stringList.add("Один");
        stringList.add("Два");
        stringList.add("Три");
        stringList.add("Четыре");
        stringList.add("Пять");
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(2);

        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.add(2,"Пять");
        System.out.println(Arrays.toString(stringList.toArray()));


//        System.out.println(stringList.size());
//
//        for (String s: stringList.toArray()) {
//            System.out.println(s);
//        }
//        stringList.remove(3);
//
//        System.out.println(stringList.size());
//        for (String s: stringList.toArray()) {
//            System.out.println(s);
//        }
//        System.out.println(stringList.get(2));
//        stringList.remove(2);
//        System.out.println(stringList.get(0));


    }
}