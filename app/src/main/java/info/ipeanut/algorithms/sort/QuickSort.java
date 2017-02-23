package info.ipeanut.algorithms.sort;

import info.ipeanut.algorithms.Utils;

/**
 * Created by chenshaosina on 16/10/3.
 *
 * 交换
 * 快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
 *
 0.目的：使数列从左到右是按由小到大排列的
 3.表现最好的排序算法。 快速排序是不稳定的,平均时间复杂度是O(nlgn)

 http://www.imooc.com/article/16141

 *
 */
public class QuickSort {

    //一次划分
    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left]; //指定第一个数为比较关键字
        int pivotPointer = left; //当前指针索引

        while(left < right) {
            while(left < right && arr[right] >= pivotKey) right --; //arr[right]大于关键字了，指针左移
            while(left < right && arr[left] <= pivotKey) left ++;

            //此时右边指针指向的arr[right]小于关键字，左边的arr[left]大于关键字，正好交换它们
            swap(arr, left, right);
        }
        swap(arr, pivotPointer, left); //最后把pivot交换到中间
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right)
            return ;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos-1);
        quickSort(arr, pivotPos+1, right);
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        quickSort(arr, 0, arr.length-1);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void main(String[] arg){
        int[] arr = {
                5,3,8,2,89,43,7,2,77,0
        };
        sort(arr);
        Utils.logArray("bubbleSort",arr);
    }

}
