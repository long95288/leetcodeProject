package com.longquanxiao;

import com.longquanxiao.struct.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}
