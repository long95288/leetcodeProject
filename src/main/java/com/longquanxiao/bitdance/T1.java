package com.longquanxiao.bitdance;

import java.util.Scanner;

/**
 * @author longquanxiao
 * @date 2019/9/8
 */
public class T1 {
    private static boolean looked = false;
    static void setLookNum(int i,int value, int[] arr, int[] looks) {
        // 循环往前查看
        for(int j = i-1;j >= 0;j --) {
            // 看见了，设置看见的值
            if (arr[j] > value) {
                // 该值被看见了
                looks[j] += 1;
                // 看见之后结束
                looked = true;
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获得第一排的数据
        int num = scanner.nextInt();
        // 输入的数组
        int[] arr = new int[num];
        // 每个数组被看见的个数
        int[] looks = new int[num];
        // 输入数组数据
        for(int i=0; i < num; i++) {
            int input = scanner.nextInt();
            arr[i] = input;
            if(i > 0) {
                // 从第二个开始设置看见的个数
                setLookNum(i, input, arr, looks);
            }
        }
        //print
        System.out.println(arr.toString());
        // 找出最大值
        System.out.println(looks.toString());
        //
        int maxLookIndex = 0;
        int max =0;
        for(int i =0;i<num; i++) {
            // 找出最大值。输出
            if (looks[i] > max) {
                max = looks[i];
                maxLookIndex = i;
            }
        }
        System.out.println("maxLookIndex="+maxLookIndex);
        System.out.println("maxLookNum="+arr[maxLookIndex]);
    }
}
