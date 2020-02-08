package com.longquanxiao;

import com.longquanxiao.struct.ListNode;

import java.util.Scanner;

/**
 * @author longquanxiao
 * @date 2019/8/1
 */
public class Solution {
    /**
     * IP地址无效化
     */
    public String defangIPaddr(String address) {
        char[] ch = address.toCharArray();
        String re = null;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '.') {
                re += "[.]";
            } else {
                re += String.valueOf(ch[i]);
            }
        }
        return re;
    }

    /**
     * 宝石的类型
     */
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            char flag = S.charAt(i);
            for (int j = 0; j < J.length(); j++) {
                if (flag == J.charAt(j)) {
                    // 相等,找到
                    num += 1;
                    break;
                }
            }
        }
        return num;
    }

    /**
     * 到达数字的终点
     */
    public static int reachNumber(int target) {
        int step = 1;
        int absTarget = Math.abs(target);
        while (step * (step + 1) / 2 < absTarget) {
            step++;
        }
        // 等差数列求和
        int sum = step * (step + 1) / 2;
        if (sum != absTarget) {
            int sub = sum - absTarget;
            step += reachNumber(sub);
        }
        return step;
    }

    public static void deleteNode(ListNode node) {
        ListNode pre = node;
        ListNode index = node.next;
        while (index != null) {
            pre.val = index.val;
            if (index.next != null) {
                pre = index;
            }
            index = index.next;
        }
        pre.next = null;
    }

    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int length = s.length;
        System.out.println("length=" + length);
        char tmp;
        for (int i = 0; i < (length / 2); i++) {
            tmp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = tmp;
        }
        System.out.println(s);
    }

    /**
     * 合并两个队列
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1 第一个
     * @param l2 第二个
     * @return 返回队列
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
         * 解决策略：边插入 边遍历
         * 1、遍历l1 查找l1所在的位置，
         * 2、如果下一个大于遍历指针，继续。小于遍历指针，从头开始
         */
        /*
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        */
        ListNode head = null;
        ListNode index = null;
        ListNode mergeIndex = null;
        if (l1.val < l2.val) {
            // 设置l1为head
            head = l1;
            index = head;
            mergeIndex = l2;
        } else {
            head = l2;
            index = head;
            mergeIndex = l1;
        }
        System.out.println("头节点:" + head.val);
        System.out.println("合并指针:" + mergeIndex.val);
        System.out.println("index:" + index.val);
        while (mergeIndex != null) {
            System.out.println("合并:" + mergeIndex.val);
            while (index != null) {
                if (index.next == null) {
                    break;
                } else if (index.val <= mergeIndex.val && mergeIndex.val < index.next.val) {
                    break;
                }
                index = index.next;
            }
            ListNode tmp = mergeIndex;
            mergeIndex = mergeIndex.next;
            tmp.next = index.next;
            index.next = tmp;
            index = tmp;
        }
        return head;
    }

    /**
     * 转换成小写
     *
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 'Z' && arr[i] >= 'A') {
                arr[i] += 32;
            }
        }
        return String.valueOf(arr);
    }

    /**
     * 递归实现累加
     */
    public static int accumulate(int n) {
        if (n < 0) {
            // 递归异常
            return -1;
        }
        if (n == 0) {
            // 递归出口
            return 0;
        } else {
            // 递归的函数体
            return n + Solution.accumulate(n - 1);
        }
    }

    /**
     * 冒泡排序
     *
     * @param array 数组
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else {
                    continue;
                }
                for (int p = 0; p < array.length; p++) {
                    System.out.print(array[p] + " ");
                }
                System.out.println();
            }
        }
        return array;
    }

    /**
     * 递归实现阶乘
     */
    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        } else {
            return n * Solution.factorial(n - 1);
        }
    }

    /**
     * 将字符串中的空格更改为%20
     * 思路:
     * 1、先计算出空格数
     * 2、根据空格数来创建新的字符数组
     * 3、然后从尾部开始移动
     */
    public static Character[] spaceChange(char[] array) {
        // 获得数组的长度
        int length = array.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == ' ') {
                count++;
            }
        }
        // 计算替换后的长度
        // 一个空格替换为%20 每个空格都会多出2个字符
        int replaceLength = length + 2 * count;
        Character[] newArray = new Character[replaceLength];
        int insertPoint = replaceLength - 1;
        for (int readPoint = length - 1; readPoint >= 0; readPoint--) {
            if (array[readPoint] == ' ') {
                // 空格更改为%20
                newArray[insertPoint] = '0';
                newArray[--insertPoint] = '2';
                newArray[--insertPoint] = '%';
                insertPoint--;
            } else {
                newArray[insertPoint] = array[readPoint];
                insertPoint--;
            }
        }
        return newArray;
    }

    /**
     * 快速排序
     * @param arr 待排序的数组
     * @param start 开始点
     * @param end 结束点
     * @return 返回排序后的结果
     */
    public static int[] quickSort(int[] arr,int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j){
            while (i<j &&arr[j] > pivot){
                j--;
            }
            while (i<j && arr[i] < pivot){
                ++i;
            }
            if(arr[i] == arr[j] && i <j){
                ++i;
            }else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(i-1 > start) {
            arr = quickSort(arr,start,i-1);
        }
        if(j+1<end){
            arr = quickSort(arr,j+1,end);
        }
        return (arr);
    }
    /**
     * 学习java的输入和输出
     */
    public static void inputAndOutput() {
        Scanner cin = new Scanner(System.in);
        int N, M;
        while (cin.hasNext()) {
            N = cin.nextInt();
            M = cin.nextInt();
            System.out.println(String.format("%d %d",N,M));
        }
    }

    /**
     * 两数之和
     * @param l1 第一个数
     * @param l2 第二个数
     * @return 相加的结果
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1!=null && l2!= null) {

        }

        // 转换成整数
        int first = 0;
        int second = 0;

        int base = 1;
        while(l1 != null) {
            first = first + l1.val * base;
            l1 = l1.next;
            base *= 10;
        }
        System.out.println("l1="+first);
        base = 1;
        while(l2 != null) {
            second = second + l2.val * base;
            l2 = l2.next;
            base *= 10;
        }
        System.out.println("l2="+second);

        base = 10;
        int add = first + second;

        System.out.println("add="+add);

        // 获得最后一个数
        int sub = add % base;
        ListNode node = new ListNode(sub);
        ListNode re = node;

        add = add - sub;
        add = add / base;

        while(add > 0) {
            sub = add % base;
            ListNode newNode = new ListNode(sub);
            node.next = newNode;
            node = newNode;
            add = add - sub;
            add = add / base;
        }
        return re;
    }
    public static int maxSubArray(int[] nums) {
        int[] opt = new int[nums.length];
        int max = nums[0];
        for(int i=0; i < nums.length; i++){
            if(i == 0){
                opt[0] = nums[0];
            } else {
              opt[i] = Math.max(opt[i-1]+nums[i],nums[i]);
              max= Math.max(opt[i],max);
            }
        }
        return max;
    }

    /**
     * 爬楼梯
     * 一次可以上一个台阶，或者上两个台阶
     * n 总的台阶数
     * 返回可能
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if (n == 1){
            return 1;
        }else if (n == 2) {
            return 2;
        }else {
            // dp 最后一个台阶上去的 + 最后是两个台阶的情况
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    /**
     * 带记录的dp
     * @param n
     * @return
     */
    public static int climbStairs2(int n){
        int[] dp = new int[n+1];
        for (int i=0;i<=n;i++){
            if (n==1){
                dp[i] =1;
            }else if(n ==2){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1] + dp[i+2];
            }
        }
        return dp[n];
    }

    /**
     * 只出现一次的数字
     * 使用异或的操作来判断是否重复
     * 相同数字异或等于0
     * 0异或任何数字都等于数字本身
     * 将数组全部异或之后，剩下的数字就是单独的数字
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        //
        int result = 0;
        for (int num :
                nums) {
            result ^= num;
        }
        //
        return result;
    }
}
