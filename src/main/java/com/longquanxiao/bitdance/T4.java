package com.longquanxiao.bitdance;

import java.util.Scanner;

/**
 * @author longquanxiao
 * @date 2019/9/8
 */
public class T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encode = scanner.nextLine();
        int base = 64;
        for(int i=0;i<encode.length();i++) {
            int add = Integer.valueOf(encode.charAt(i));

            System.out.print(Character.toChars(base+add));
        }
        System.out.println();
    }
}
