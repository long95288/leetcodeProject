package com.longquanxiao;

import com.longquanxiao.struct.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * @author longquanxiao
 * @date 2019/8/1
 */
public class SolutionTest {

    @Test
    public void defangIPaddr() {
    }

    @Test
    public void numJewelsInStones() {
    }

    @Test
    public void reachNumber() {
    }

    @Test
    public void deleteNode() {
    }

    @Test
    public void reverseString() {
        Solution solution = new Solution();
        char[] s = "hello".toCharArray();
        solution.reverseString(s);
    }

    @Test
    public void mergeTwoLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode re = Solution.mergeTwoLists(l1,l2);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }
    @Test
    public void testNode(){
        ArrayList<LinkedList<String>> arrayList  = new ArrayList<>(10);

        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(linkedList.hashCode());
        System.out.println("对象地址"+System.identityHashCode(linkedList));
        arrayList.add(linkedList);

        LinkedList<String> index = arrayList.get(0);
        System.out.println(index.hashCode());
        System.out.println("对象地址"+System.identityHashCode(index));

        index.add("1");
        index.add("2");

        LinkedList<String> row2 = new LinkedList<>();
        row2.add("3");
        row2.add("3");
        row2.add("ooo");

        arrayList.add(row2);

        for(int i=0;i<arrayList.size();i++){
            LinkedList<String> index2 = arrayList.get(i);
            for(int j=0;j<index2.size();j++){
                System.out.print("index="+index2.get(j));
            }
            System.out.println();
        }

    }

    @Test
    public void toLowerCase() {
        String str = "Hello world";
        System.out.println(Solution.toLowerCase(str));
    }

    @Test
    public void accumulate() {
        int n = 30;
        // 结果应该为 30*(30+1)/2 = 465
        int result = Solution.accumulate(n);
        assertEquals(465,result);
    }

    @Test
    public void factorial() {
        int n = 5;
        int result = Solution.factorial(n);
        assertEquals(120,result);
    }

    @Test
    public void bubbleSort() {
        int[] array = {1,2,5,6,4,3};
        array = Solution.bubbleSort(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    @Test
    public void spaceChange() {
        char[] array = "Hello World ,I'am a coder".toCharArray();
        Character[] ret = Solution.spaceChange(array);
        for (int i= 0;i < ret.length;i++){
            System.out.print(ret[i]);
        }
        System.out.println();
    }
    @Test
    public void testQuickSort() {
        int[] arr = new int[]{4,3,12,5,67,88,125,62};
        int length = arr.length;
        arr = Solution.quickSort(arr,0,length-1);
        for(int i:arr){
            System.out.print(i+"\t");
        }
        System.out.println("");
    }

    @Test
    public void testInputAndOutput() {
        Solution.inputAndOutput();
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(2);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        l1.next = a;
        a.next = b;

        ListNode l2 = new ListNode(5);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(4);
        l2.next = c;
        c.next = d;

        ListNode re = Solution.addTwoNumbers(l1,l2);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }

    }
    @Test
    public void testMaxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = Solution.maxSubArray(nums);
        assertEquals(max,6);

    }

    @Test
    public void testClimbStairs() {
        int top = 1;
        assertEquals(1,Solution.climbStairs(top));
        top = 2;
        assertEquals(2,Solution.climbStairs(top));
        top = 3;
        assertEquals(3, Solution.climbStairs(top));
    }

    @Test
    public void testSingleNumber() {
        int[] nums = {1,1,2};
        assertEquals(2,Solution.singleNumber(nums));
    }

    @Test
    public void testReverse() {
        int result = Solution.reverse(123);
        assertEquals(321,result);
        result = Solution.reverse(-123);
        assertEquals(-321,result);
        result = Solution.reverse(120);
        assertEquals(21,result);
        result = Solution.reverse(901000);
        assertEquals(109,result);
        result = Solution.reverse(1534236469);
        assertEquals(0,result);
        assertEquals(0,Solution.reverse(-1534236469));

    }

    @Test
    public void testIsPalindrome() {
        // assertEquals(true,Solution.isPalindrome(120));
        assertEquals(true,Solution.isPalindrome(1410110141));
        assertEquals(false,Solution.isPalindrome(-121));
    }
}
