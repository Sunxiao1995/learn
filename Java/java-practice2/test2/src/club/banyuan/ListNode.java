package club.banyuan;
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    public void setVal(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int scale = 0;
        ListNode sumNode = new ListNode(0);
        sumNode.val = (l1.val+l2.val)%10;
        scale = (l1.val+l2.val)/10;
        ListNode temp = sumNode;
        while(l1.next != null || l2.next != null){
            if(l1.next == null) {
                l1.next = new ListNode(0);
            }
            if(l2.next == null) {
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = (l1.val+l2.val+scale)%10;
            scale = (l1.val+l2.val+scale)/10;
        }
        if (scale != 0) {
            temp.next = new ListNode(0);
            ListNode end = temp.next;
            end.val = scale;
        }
        return sumNode;
    }
}

class Test{
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l11.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(8);
        l21.next = l22;
        Solution a = new Solution();
        ListNode temp = a.addTwoNumbers(l11,l21);
        while (temp!= null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}