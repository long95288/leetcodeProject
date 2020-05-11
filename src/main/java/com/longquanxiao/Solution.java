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

        return null;
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

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums){
        // 等差数列的和为 n(n+1)/2
        // 缺失的数字 = 未缺失的数组和 - 缺失的数组和
        //
        int n = nums.length;
        int result = 0;
        for (int num :
                nums) {
            result += num;
        }
        return n*(n+1)/2 - result;
    }

    /**
     * 27、移除元素
     *  给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val){
       // 新数组的遍历下标
        int point = -1;
        for (int i = 0; i < nums.length; i++) {
            // i 为遍历指针
            if (nums[i] != val){
                // 开辟新空间
                point ++;
                // 将当前的数字赋值到新数组中
                nums[point] = nums[i];
            }
        }
        // 返回新数组的长度
       return point + 1;
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public static int reverse(int x){
        int result = 0;
        // 正负标识
        boolean status = true;
        // append flag
        boolean appendFlage = false;

        if (x < 0){
            status = false;
        }
        String value = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(status){
            // 正数处理
            for (int i = value.length() -1; i >= 0; i--) {
                if(value.charAt(i) == '0' && !appendFlage){
                    continue;
                }else {
                    appendFlage = true;
                }
                sb.append(value.charAt(i));
            }
            try{
               result = Integer.valueOf(sb.toString());
            }catch (NumberFormatException e){
                // null
            }
        }else{
            // 负数处理
            sb.append('-');
            for (int i = value.length()-1; i >= 1; i--) {
                if(value.charAt(i) == '0' && !appendFlage){
                    continue;
                }else{
                    appendFlage = true;
                }
                sb.append(value.charAt(i));
            }
            try {
                result = Integer.valueOf(sb.toString());
            }catch (NumberFormatException e){}
        }
        return result;
    }

    /**
     * 121
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x){
        // 负数肯定不是回文数
        if (x < 0) return false;
        // 个位数为回文数
        if(x>=0 && x<10) return true;

        // 整数翻转,相同为回文
        long copyData = x;
        // 121 = 1*100 + 2*10 + 1*1
        // 获取数字的最高位数
        long baseSub = 1;
        int length = 0;
        while (copyData/baseSub != 0){
            length += 1;
            baseSub *= 10;
        }
        System.out.println("整数的位数:"+length);
        long newData = 0;
        length --;
        // 构建新的数据
        while (copyData > 0){
            newData = (copyData % 10) * (long)Math.pow(10,length) + newData;
            // 减去已经记录的,并且下一次乘数减一
            copyData /= 10;
            if (copyData == 0) break;
            length --;
        }
        System.out.println("newData:"+newData);
        if (newData == x) {
            return true;
        }
        return false;
    }

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        if (!isDuplication(S)){
            return S;
        }
        // 去除重复项
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (i == S.length() -1){
                sb.append(S.charAt(i));
                break;
            }
            if (S.charAt(i + 1) == S.charAt(i)) {
                i++;
                continue;
            }
            sb.append(S.charAt(i));
        }
        return removeDuplicates(sb.toString());
    }
    private boolean isDuplication(String s){
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)){
                return true;
            }
        }
        return false;
    }
    public int removeDuplicates(int[] nums) {
        // 第一个肯定不重复
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if (nums[index] != nums[i]){
                // 等价于开辟新空间
                index ++;
                // 赋值
                nums[index] =nums[i];
            }
        }
        return index+1;
    }

    /**
     * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
     *
     * 示例1:
     *
     *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
     *  输出: 8（元素5在该数组中的索引）
     * 示例2:
     *
     *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
     *  输出：-1 （没有找到）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        int first = 0;
        int last = arr.length-1;
        while (first != last){
            // 二分点
            int mid = (first + last )/2;
            // 重置二分点
            if (arr[first] < arr[mid]){
                // 左边单增数据
                if(target >= arr[first] && target <= arr[mid]){
                    // target位于左边
                    // [target]mid[]
                    last = mid;
                }else{
                    // target 位于右边
                    // []mid[target]
                    first = mid + 1;
                }
            }else if (arr[first] > arr[mid]){
                // 增减都有
                if (arr[first] <= target || target<= arr[mid]){
                    // [target]mid[]
                    last = mid;
                }else{
                    // []mid[target]
                    first = mid + 1;
                }
            }else if (arr[first] == arr[mid]){
                if (arr[first] != target){
                    first ++;
                }else {
                    last = first;
                }
            }
        }
        return (arr[first] == target)?first:-1;
    }
}
