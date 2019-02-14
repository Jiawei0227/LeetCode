package com.top100Liked;

import java.util.PriorityQueue;

/**
 * Created by Jerry Wang on 12/07/2018.
 */
public class Merge2List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while(pointer1 != null && pointer2 !=null){
            if(pointer1.val <= pointer2.val) {
                temp.next = pointer1;
                pointer1 = pointer1.next;
                temp = temp.next;
            }else{
                temp.next = pointer2;
                pointer2 = pointer2.next;
                temp = temp.next;
            }
        }

        if(pointer1 == null){
            temp.next = pointer2;
        }else {
            temp.next = pointer1;
        }

        return head.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while(head != null) {
            int min = -1;
            int maxValue = Integer.MAX_VALUE;
            for(int i = 0;i<lists.length ; i++){
                if(lists[i] == null)
                    continue;
                if(lists[i].val < maxValue) {
                    //System.out.println(lists[i].val);
                    min = i;
                    maxValue = lists[i].val;
                }
            }
            if(min == -1)
                break;
            head.next = lists[min];
            lists[min] = lists[min].next;


            head = head.next;

        }

        return res.next;

    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(o1,o2)->(o1.val-o2.val));

        for(ListNode node : lists)
            if(node!=null)
                queue.add(node);

        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        while(!queue.isEmpty()){
            pointer.next = queue.poll();
            pointer = pointer.next;
            if(pointer.next != null)
                queue.add(pointer.next);
        }
        return dummy.next;


    }


    public static void main(String args[]){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        a.next = b;
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        c.next = d;
        ListNode e = new ListNode(5);
        ListNode[] test = new ListNode[3];
        test[0] = a;
        test[1] = c;
        test[2] = e;
        ListNode result = Merge2List.mergeKLists2(test);
        while(result!=null) {
            System.out.print(result.val);
            result = result.next;
        }

    }
}
