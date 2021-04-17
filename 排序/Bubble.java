package cn.aguo.bubble;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Code Fruit
 * @Email 1260839205@qq.com
 * @Date 2021/4/17 下午8:09
 * @实现：冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        //调用方法生成随机数
        int[] randomNumbers = getRandomNumbers();
        System.out.println("未排序前数字为："+ Arrays.toString(randomNumbers));

        //调用方法实现冒泡排序
        int[] numbers = bubbleSort(randomNumbers);


    }
    /**
     * 生成随机数的方法
     * @return
     */
    public static int[] getRandomNumbers(){
        //1.在100以内随机生成十个正整数，作为排序的基数
        //1.1 创建Integer(int的引用类型)的数组来存储随机数
        int[] numbers = new int[10];
        //1.2 创建随机函数
        Random rd = new Random();

        //2.循环生成随机数，并存入数组
        for(int i = 0;i < numbers.length;i++) {
            //2.1 每次循环生成[0,100)区间内的一个随机数
            numbers[i] = rd.nextInt(100);
        }
        return numbers;
    }

    /**
     * 冒泡排序的方法
     * @param numbers
     */
    public static int[] bubbleSort(int[] numbers){
        //第一层循环代表主循环次数
        for (int i = 0; i < numbers.length - 1; i++) {
            //第二层循环每次减少循环最后以排好序后的次数
            for (int j = 0; j < numbers.length - i - 1; j++) {
                int num = 0;
                //若前一位数大于后一位数则交换位置
                if (numbers[j] > numbers[j + 1]){
                    num = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = num;
                }
            }
            System.out.println("排序第"+(i + 1)+"次："+Arrays.toString(numbers));
        }
        return numbers;
    }

}
