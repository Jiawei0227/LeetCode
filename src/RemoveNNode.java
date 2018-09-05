/**
 * Created by Jerry Wang on 12/07/2018.
 */
public class RemoveNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null)
            return null;

        ListNode after = head;
        ListNode pointer = head;
        for(int i = 0;i<n;i++) {
            pointer = pointer.next;

        }

        if (pointer == null)
            return head.next;

        while(pointer.next != null){
            after = after.next;
            pointer = pointer.next;
        }

        after.next = after.next.next;

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}