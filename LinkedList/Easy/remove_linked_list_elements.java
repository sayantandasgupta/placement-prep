package LinkedList.Easy;

public class remove_linked_list_elements {
    /*
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

        Example 1:


        Input: head = [1,2,6,3,4,5,6], val = 6
        Output: [1,2,3,4,5]
        Example 2:

        Input: head = [], val = 1
        Output: []
        Example 3:

        Input: head = [7,7,7,7], val = 7
        Output: []
        

        Constraints:

        The number of nodes in the list is in the range [0, 104].
        1 <= Node.val <= 50
        0 <= val <= 50
     */

     static class ListNode {
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
     }

     static ListNode head = new ListNode();


     static ListNode solution(ListNode head, int val) {
        ListNode current = head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        while(current!=null) {
            if(current.val==val) {
                prev.next = current.next;
            } else {
                prev = current.next;
            }

            current = current.next;
        }

        return temp.next;
     }

     public static void main(String[] args) {

        int[] arr = {1,2,6,3,4,5,6};

        ListNode temp = head;

        for(int i : arr) {
            temp.val = i;
            temp.next = new ListNode();
            temp = temp.next;
        }

        temp = head;

        System.out.println("Linked List Before removing the given value: \n");

        while(temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();

        int val = 6;

        head = solution(head, val);

        temp = head;

        System.out.println("Linked List after removing the given value: \n");

        while(temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        return;
     }
}
