package cn.aguo.algorithm.dichotomous;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author Code Fruit
 * @Email 1260839205@qq.com
 * @Date 2021/4/14 下午9:02
 */
public class Dichotomous {

    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args){
        //调用getRandomNumbers()方法生成随机数
        Integer[] numbers = getRandomNumbers();
        System.out.println("生成的随机数为：");
        //将数组内的数字进行排序
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        //创建输入函数，接收用户输入需要查询的数字
        Scanner sc = new Scanner(System.in);
        int num; //用户输入的数字
        System.out.print("输入如上数组内需要查询的数字：");
        num = sc.nextInt();
        find(num,numbers);
    }

    /**
     * 生成随机数的方法
     * @return
     */
    public static Integer[] getRandomNumbers(){
        //1.在100以内随机生成十个不同的正整数，作为查找的基数
        //1.1 创建Integer(int的引用类型)的数组来存储随机数
        Integer[] numbers = new Integer[10];
        //1.2 创建随机函数
        Random rd = new Random();

        //2.循环生成随机数，并存入数组
        for(int i = 0;i < numbers.length;i++) {
            //2.1 每次循环生成[0,100)区间内的一个随机数
            int num = rd.nextInt(100);
            //2.2 创建一个布尔值，默认值为true，表示默认生成的数字，数组内不存在
            boolean flag = true;
            //2.3 循环遍历数组内已存数字
            for (int j = 0; j < i; j++) {
                //2.4 判断数组内已存在的数组是否与随机生成的数字相同
                if (numbers[j] == num){
                    //相同则将flag置false，并结束本次遍历
                    flag = false;
                    break;
                }
            }
            //2.5 若flag为true，则将生成的数字存入数组，否则循环次数无效恢复为上一次循环的值
            if (flag){
                numbers[i] = num;
            }else {
                i--;
            }
        }
        return numbers;
    }

    /**
     * 二分查找的方法
     * @param num 接收用户想要查找的数字
     * @param numbers 查找数字的序列
     */
    public static void find(int num,Integer[] numbers){
        /**
         * first ：第一个值的下标 默认值为0
         * middle ： 中间值的下标 默认值为(frist + last) / 2 并且向上取整
         * last ： 最后一个值的下标 默认值为numbers.length - 1
         * count : 统计比较次数 默认值为0
         */
       int first ,  middle, last, count;
       first = 0;
       last = numbers.length - 1;
       count = 0;

       while(true){
           count ++;
           middle = (int)Math.floor(((float) first + (float) last) / 2);
           System.out.println("第"+count+"次，first为："+first+",middle为："+middle+",last为："+last);
           if (num > numbers[middle]){ //比较输入的数字是否大于该次中间值，若大于则证明前一部分无相同
               first = middle + 1;
           }else if (num < numbers[middle]){//比较输入的数字是否大于该次中间值，若小于则证明后一部分无相同
               last = middle - 1;
           }else if (num == numbers[middle]){ //若相同则跳出循环
               break;
           }else {
               System.out.println("您输入的数字该序列中没有！！！");
           }
       }
        System.out.println("一共比较了"+count+"次，在下标为"+middle+"的位置找到"+numbers[middle]);
    }
}
