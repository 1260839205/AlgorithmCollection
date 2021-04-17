package cn.aguo.bubble;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Code Fruit
 * @Email 1260839205@qq.com
 * @Date 2021/4/17 下午8:43
 */
public class Select {
    public static void main(String[] args) {
        //调用方法生成随机十个数
        int[] randomNumbers = getRandomNumbers();
        System.out.println("未排序为："+Arrays.toString(randomNumbers));

        //调用方法进行排序
        selectSort(randomNumbers);
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
     * 选择排序--实现方法
     * @param numbers
     */
    public static void selectSort(int[] numbers){
        int maxSubscript,num; //最大值下标 & 数字交换时存放数字的变量
        for (int i = 0; i < numbers.length - 1; i++) {
            maxSubscript = i; //初始化最大值下标
            for (int j = i + 1 ; j < numbers.length; j++) {
                if (numbers[maxSubscript] < numbers[j]){ //判断前一个数是否大于后一个数，若大于则保存下标
                    maxSubscript = j;
                }
            }
            //两数交换
            num = numbers[i];
            numbers[i] = numbers[maxSubscript];
            numbers[maxSubscript] = num;
            System.out.println("第"+(i + 1)+"次寻找最大值，并放在最前面："+ Arrays.toString(numbers));
        }
    }
}
