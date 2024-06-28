public class Bai3 {
    
    static class ListNode {
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public static ListNode easySet(int[] arr){
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
    
            for (int i : arr) {
                ListNode newNode = new ListNode(i);
                tail.next = newNode;
                tail = tail.next;
            }
    
            ListNode result = dummyHead.next;
            dummyHead.next = null;
            return result;
        }
    }

    class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            int carry = 0;
    
            while (l1 != null || l2 != null || carry != 0) {
                int digit1 = (l1 != null) ? l1.val : 0;
                int digit2 = (l2 != null) ? l2.val : 0;
    
                int sum = digit1 + digit2 + carry;
                int digit = sum % 10;
                carry = sum / 10;
    
                ListNode newNode = new ListNode(digit);
                tail.next = newNode;
                tail = tail.next;
    
                l1 = (l1 != null) ? l1.next : null;
                l2 = (l2 != null) ? l2.next : null;
            }
    
            ListNode result = dummyHead.next;
            return result;
        }
    }

    public static void main(String[] args) {
        int[] l1Arr = {9,9,9,9,9,9,9,9};
        int[] l2Arr = {9,9,9,9,9};

        ListNode l1 = ListNode.easySet(l1Arr);
        ListNode l2 = ListNode.easySet(l2Arr);

        ListNode sum = Solution.addTwoNumbers(l1, l2);
        printListNode(sum);
    }

    public static void printListNode(ListNode l) {
        ListNode head = l;

        while (head != null) {
            System.out.print(head.val + " ");

            head = head.next;
        }
    }
}
