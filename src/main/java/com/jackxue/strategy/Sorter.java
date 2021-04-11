package com.jackxue.strategy;

public class Sorter<T> {
    public void sort(T[] arr, Comparator<T> comparator){
        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int ret = comparator.compare(arr[i], arr[j]);
                if(ret > 0){
                    swap(arr, i, j);
                }
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
