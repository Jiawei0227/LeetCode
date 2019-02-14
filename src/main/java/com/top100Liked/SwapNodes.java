package com.top100Liked;

/**
 * Created by Jerry Wang on 13/07/2018.
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode pointer = head.next;
        head.next = swapPairs(pointer.next);
        pointer.next = head;

        return pointer;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        if(head == null)
            return null;
        for(int i = 1;i<k;i++){
            tmp = tmp.next;
            if(tmp == null)
                return head;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
       // System.out.println(tmp.val);
        ListNode nextList = reverseKGroup(tmp.next,k);


        for(int i = 0 ;i<k;i++){
            pointer1.next = nextList;
            nextList = pointer1;
            pointer1 = pointer2;
            if(pointer1 == null)
                break;
            pointer2 = pointer1.next;
        }
        return nextList;
    }

    public static void main(String args[]){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode result = SwapNodes.reverseKGroup(a,2);
        while(result!=null) {
            System.out.print(result.val);
            result = result.next;
        }

    }
}
