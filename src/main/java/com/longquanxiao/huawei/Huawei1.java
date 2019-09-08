package com.longquanxiao.huawei;

import java.util.Scanner;

/**
 * @author longquanxiao
 * @date 2019/9/7
 */
public class Huawei1 {
    public static void main(String[] args) {
        // 声明数组数据
        int[] arr = new int[100];
        // 数组的数据大小
        int len = 0;
        Scanner scanner = new Scanner(System.in);
        // 输入数组
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");
        len = strArray.length;
        for (int i=0;i < len; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }
       for( int i=0;i<len;i++) {
           System.out.println(arr[i]);
       }
    }
}
