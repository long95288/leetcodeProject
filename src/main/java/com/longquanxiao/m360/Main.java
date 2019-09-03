package com.longquanxiao.m360;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author longquanxiao
 * @date 2019/8/31
 */
public class Main {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = null;
        while (cin.hasNext()) {
            str = cin.next();
            ArrayList<String> substr = new ArrayList<>();
            // 拿到字串
            for (int subLength = 1;subLength <= str.length() -2;subLength ++){
                for(int j=0;j < str.length()-1;j = j+subLength){
                    String sub = str.substring(j,subLength);
                    System.out.println("添加");
                    substr.add(sub);
                }
            }
            System.out.println(substr);
        }
    }

}
