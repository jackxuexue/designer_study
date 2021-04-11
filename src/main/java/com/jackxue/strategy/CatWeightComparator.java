package com.jackxue.strategy;

public class CatWeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.getWeight() > o2.getWeight()) return 1;
        else if(o1.getWeight() < o2.getWeight()) return -1;
        else return 0;
    }
}
