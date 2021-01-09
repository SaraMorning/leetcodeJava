package com.algorithm;

public class LC0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        int number1 = findkthNumber(nums1, 0, nums2, 0, (num1Size + num2Size + 1) / 2);
        int number2 = findkthNumber(nums1, 0, nums2, 0, (num1Size + num2Size + 2) / 2);
        double result = (number1 + number2) / 2.0;
        return result;
    }

    public int findkthNumber(int[] nums1, int startA,
                             int[] nums2, int startB, int k) {
        int compareA = nums1.length - startA;
        int compareB = nums2.length - startB;
        if (compareA > compareB) {
            return findkthNumber(nums2, startB, nums1, startA, k);
        }
        if (compareA == 0) return nums2[k - 1];
        if (k == 1) {
            return Math.min(nums1[startA], nums2[startB]);
        }
        int partA = Math.min(compareA, k / 2);
        int partB = k - partA;
        if (nums1[startA + partA - 1] == nums2[startB + partB - 1]) {
            return nums1[startA + partA - 1];
        } else if (nums1[startA + partA - 1] < nums2[startB + partB - 1]) {
            return findkthNumber(nums1, startA + partA, nums2, startB, k - partA);
        } else {
            return findkthNumber(nums1, startA, nums2, startB + partB, k - partB);
        }
    }

    /*
     *循环实现二分算法
     */
    public static int binSearch_1(int key, int[] array) {
        int low = 0; //第一个下标
        int high = array.length - 1;//最后一个下标
        int middle = 0;
        //防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (middle == key) {
                return array[middle];
            } else if (middle < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /*
     *递归实现二分算法
     */
    public static int binSearch_2(int key,int[] array,int low,int high){
        //防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        int middle = (low+high)/2;
        if(array[middle]>key){
            //大于关键字
            return  binSearch_2(key,array,low,middle-1);
        }else if(array[middle]<key){
            //小于关键字
            return binSearch_2(key,array,middle+1,high);
        }else{
            return array[middle];
        }
    }
}
