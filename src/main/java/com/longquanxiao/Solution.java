package com.longquanxiao;

import com.longquanxiao.struct.ListNode;

/**
 * @author longquanxiao
 * @date 2019/8/1
 */
public class Solution {
    /**
     * IP地址无效化
     * */
    public String defangIPaddr(String address){
        char[] ch = address.toCharArray();
        String re=null;
        for (int i=0;i<ch.length;i++){
            if(ch[i] == '.'){
                re += "[.]";
            }else{
                re += String.valueOf(ch[i]);
            }
        }
        return re;
    }
    /**
     * 宝石的类型
     * */
    public int numJewelsInStones(String J, String S) {
        int num=0;
        for(int i=0;i<S.length();i++){
            char flag = S.charAt(i);
            for(int j=0;j<J.length();j++){
                if(flag == J.charAt(j)){
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
     * */
    public static int reachNumber(int target) {
        int step = 1;
        int absTarget = Math.abs(target);
        while (step*(step+1)/2 < absTarget){step ++;}
        // 等差数列求和
        int sum = step*(step+1)/2;
        if(sum != absTarget){
            int sub = sum - absTarget;
            step += reachNumber(sub);
        }
        return step;
    }

    public static void deleteNode(ListNode node){
        ListNode pre = node;
        ListNode index = node.next;
        while( index != null) {
            pre.val = index.val;
            if(index.next != null){
                pre = index;
            }
            index = index.next;
        }
        pre.next = null;
    }

    /**
     * 反转字符串
     * @param s
     */
    public void reverseString(char[] s) {
        int length = s.length;
        System.out.println("length="+length);
        char tmp;
        for (int i=0;i<(length/2);i++) {
            tmp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = tmp;
        }
        System.out.println(s);
    }

    /**
     * 合并两个队列
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
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
        if(l1.val < l2.val) {
            // 设置l1为head
            head = l1;
            index = head;
            mergeIndex = l2;
        }else {
            head = l2;
            index = head;
            mergeIndex = l1;
        }
        System.out.println("头节点:"+head.val);
        System.out.println("合并指针:"+mergeIndex.val);
        System.out.println("index:"+index.val);
        while(mergeIndex != null){
            System.out.println("合并:"+mergeIndex.val);
            while (index!=null){
                if(index.next == null){
                    break;
                }else if(index.val <= mergeIndex.val && mergeIndex.val < index.next.val){
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
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= 'Z' && arr[i] >= 'A'){
                arr[i] += 32;
            }
        }
        return String.valueOf(arr);
    }
    /**
     * 递归实现累加
     */
    public static int accumulate(int n){
        if(n < 0){
            // 递归异常
            return -1;
        }
        if(n == 0){
            // 递归出口
           return 0;
        }else {
            // 递归的函数体
            return n + Solution.accumulate(n-1);
        }
    }

    /**
     * 冒泡排序
     * @param array 数组
     * @return
     */
    public static int[] bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for (int j=i+1; j<array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }else{
                    continue;
                }
                for(int p=0;p<array.length;p++){
                    System.out.print(array[p]+" ");
                }
                System.out.println();
            }
        }
        return array;
    }

    /**
     * 递归实现阶乘
     */
    public static int factorial(int n){
        if(n<0){
            return -1;
        }
        if(n == 1){
            return 1;
        } else {
          return n * Solution.factorial(n-1);
        }
    }

}
