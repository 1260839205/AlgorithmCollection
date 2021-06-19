package cn.aguo.quick;

import java.util.Arrays;

/**
 * @Author Code Fruit
 * @Email 1260839205@qq.com
 * @Date 2021/6/19 下午4:41
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {4,1,8,3,7,5};
        System.out.println("排序前：" + Arrays.toString(arr));
        System.out.println("排序后：" + Arrays.toString(quickSort(arr,0,arr.length - 1)));
    }

    public static int[] quickSort(int[] arr,int left, int right){

        if (left == right){
            return arr;
        }

        //基准数
        int pivot = arr[left];
        int num = left, num2 =right;

        while(left < right){
            while(pivot <= arr[right] && left < right){
                right--;
            }
            while(pivot >= arr[left] && left < right){
                left++;
            }
            arr = sort(arr,left,right);
        }
        arr = sort(arr,num,left);

        quickSort(arr,num,left - 1);
        quickSort(arr,left + 1,num2);
        return arr;
    }

    private static int[] sort(int[] arr,int i, int j){
        int num;
        num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
        return arr;
    }
}
