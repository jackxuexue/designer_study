package com.jackxue.strategy;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
       /* Integer[] arr = {5, 3, 9, 2, 1};
        Sorter<Integer> sorter = new Sorter<>();

        sorter.sort(arr, new IntegerComparator());
        System.out.println(Arrays.toString(arr));*/

        Cat[] cats = {new Cat(5, 5), new Cat(3, 3),
                new Cat(1,1), new Cat(9, 9)};
        Sorter<Cat> sorter = new Sorter<>();
        /*sorter.sort(cats, new CatWeightComparator());*/
        sorter.sort(cats, (o1, o2)->{
            if(o1.getHeight() > o2.getHeight()) return 1;
            else if(o1.getHeight() < o2.getHeight()) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(cats));
    }
}
