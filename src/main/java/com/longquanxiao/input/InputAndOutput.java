package com.longquanxiao.input;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 测试输入输出
 * @author longquanxiao
 * @date 2019/8/30
 */
public class InputAndOutput {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N, M;
        ArrayList<Integer> array = new ArrayList<>();
        while (cin.hasNext()){
            N = cin.nextInt();
            M = cin.nextInt();
            System.out.println(String.format("输出 %d %d",N,M));
            for (int i=0;i < 2;i++) {
               array.add(cin.nextInt());
            }
            System.out.println(array);
        }
    }
}
