package cn.aguo.bubble;

import java.util.Arrays;

/**
 * @Author Code Fruit
 * @Email 1260839205@qq.com
 * @Date 2021/6/23 下午2:13
 */
public class MergeSort {

    public static void sort(int[] arr, int left, int mid, int right){
        int i = left,j = mid + 1 , num = 0;
        int[] temp = new int[right - left + 1];
        //将数组中小的存入新数组
        while(i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[num++] = arr[i++];
            }else {
                temp[num++] = arr[j++];
            }
        }

        //将左边未移动完的移动到新数组
        while(i <= mid){
            temp[num++] = arr[i++];
        }

        //将右边未移动完的移动到新数组
        while(j <= right){
            temp[num++] = arr[j++];
        }

        //将排序好的新数组放到old数组原来的位置
        for (int a = 0; a < temp.length; a++) {
            arr[left + a] = temp[a];
        }
        //return arr;
    }

    /**
     * 归并排序方法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] mergeSort(int[] arr,int left ,int right){
        //当数组内只有一个元素直接返回数组
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid );
            mergeSort(arr,mid + 1,right);
            sort(arr, left, mid, right);
        }
        return arr;
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {4,1,8,3,7,5,6};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
    }
}
