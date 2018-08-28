package com.jmp.moudle.Algorithmn;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 9:58
 * 二分法： （二分法不是只能做数组，这里的数组只是为了完成demo）
                在给出的有序排列的数组中，把目标值和数组中间值进行比较，如果相等，则返回中间值下标，如果目标值小于中间值，就从数
             组的前半段再次执行二分法查找，如果目标值大于中间值，从数组的后半段开始二分法查找
             二分法查找主要是比较的次数少，查找的速度快，平均性能好，但是待查表一定要是有序的，
             插入删除比较困难，所以二分法查找不适用于经常变动的有序列表
 */
public class TwoPointCls {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.err.println(searchRecursive(arr, 0, arr.length - 1, 6));
    }

    private static int searchRecursive(int[] arr, int start, int end, int findValue) {
        if (arr == null) {
            return -1;
        }
        if (start <= end) {
            //中间位置
            int middle = (end + start) / 2;
            int middleValue = arr[middle];

            if (findValue == middleValue) {
                return middle;
            } else if (findValue < middleValue) {
                return searchRecursive(arr, start, middle - 1, findValue);
            } else {
                return searchRecursive(arr, middle + 1, end, findValue);
            }
        } else {
            return -1;
        }
    }
}
