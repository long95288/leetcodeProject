package com.longquanxiao.xunfei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author longquanxiao
 * @date 2019/9/8
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 解析数据
        int columnNum = Integer.parseInt(input.split(";")[0]);
        String data = input.split(";")[1];
        System.out.println("num = "+ columnNum);
        System.out.println("data =" +data);
        // 放置存数据的对象
        ArrayList<Character> arrayList = new ArrayList<>();
        ArrayList<char[]> arrayList1 = new ArrayList<>();
        // 读取数据放置
        for(int i=0;i<data.length();i++) {
            char[] newArrary = new char[columnNum];
            for(int j=0;j < columnNum;j++){
                if(i < data.length()){
                    newArrary[j] = data.charAt(i);
                    i++;
                }
            }
            arrayList1.add(newArrary);
            // arrayList.add(data.charAt(i));
        }
        // test
        System.out.println(arrayList);
        System.out.println(arrayList1);
        StringBuilder out = new StringBuilder();
        for(int i=0;i<columnNum;i++){
            for(int j =0; j<arrayList1.size(); j++){
                if (arrayList1.get(j)[i] == ' ') {
                    out.append(" ");
                }else if (arrayList1.get(j)[i] == '\0' ){
                    out.append(" ");
                }
                else
                {
                out.append(arrayList1.get(j)[i]);
                 }
            }
        }
        System.out.println(out.toString().trim());
//        // 按没有充满一行，就要直接输出行
//        if(arrayList.size() < columnNum) {
//           for(int i= 0;i<arrayList.size();i++) {
//               System.out.print(arrayList.get(i));
//           }
//           System.out.println();
//        } else {
//            // 输出列
//            StringBuilder stringBuilder = new StringBuilder();
//
//            for(int i=0;i < columnNum;i++) {
//                int base = i;
//                while (base < arrayList.size()) {
//                    if(arrayList.get(base) == ' '){
//                        stringBuilder.append(" ");
//                    }else {
//                        stringBuilder.append(arrayList.get(base));
//                    }
//                    base = base + columnNum;
//                }
//            }
//            System.out.println(stringBuilder.toString());
//        }

    }
}
