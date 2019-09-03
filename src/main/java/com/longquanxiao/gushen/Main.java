package com.longquanxiao.gushen;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

/**股神
 * @author longquanxiao
 * @date 2019/8/31
 */
public class Main {
        public static int getPrice(int n){
            int price = 1;
            if(n == 1) return 1;
            else if(n == 2) return 2;
            else if(n == 3) return 1;
            else {
                price = 1;
                int flag = 6;
                int base = 3;
                for (int i =4;i <= n; i++){
                    if(i == flag) {
                        System.out.println("flag:"+flag);
                        price = price -1;
                        base = base +1;
                        flag = flag + base;
                    }else {
                        price  = price +1;
                    }
                }
                return price;
            }
        }
        public static void main(String[] args){
            Scanner cin = new Scanner(System.in);
            while(cin.hasNext()){
                int n = cin.nextInt();
                System.out.println(Main.getPrice(n));
            }
        }
}
