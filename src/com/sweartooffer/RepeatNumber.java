package com.sweartooffer;

import java.util.ArrayList;
import java.util.List;

public class RepeatNumber {

    /**
     * 找出数组中重复的数字
     *
     * @param arr
     */

    static List<Integer> list = new ArrayList<>();

    public static boolean solution1(int[] arr) {

        //方法一：排序、遍历找到重复数字 O(nlogn)
        //方法二：哈希表，遍历结果数组对应的下标是否存在重复值，时间O(n),空间O(n)
        //方法三：

        if (arr.length == 0){
            return false;
        }

        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 0 || arr[i] > arr.length - 1){
                return false;
            }
        }

        for (int i = 0; i < arr.length; i++){
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    list.add(arr[i]);
                    return true;
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }

        return false;
    }

}
