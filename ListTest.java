package al.leetcod;

public class ListTest {

    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre =preHead ;

        while(l1 !=null && l2 !=null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 == null) pre.next=l2;
        if(l2 == null) pre.next=l1;

        return preHead.next;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int tem = 0;

        while (l1 != null && l2 !=null){

            pre.next = new ListNode((l1.val+l2.val+tem)%10);
            tem = (l1.val +l2.val+tem)/10;
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        while (l1 != null ){

            pre.next = new ListNode((l1.val +tem)%10);
            tem = (l1.val+tem)/10;
            l1 = l1.next;
            pre = pre.next;
        }
        while (l2 != null ){
            pre.next = new ListNode((l2.val+tem)%10);
            tem = (l2.val+tem)/10;
            l2 = l2.next;
            pre = pre.next;
        }
        if (tem > 0 ){
            pre.next = new ListNode(tem);

        }
        return head.next;



    }

    public  static void printa(ListNode a){
        while (a != null){
            System.out.println(a.val);
            a = a.next;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(0);
       // l1.next = new ListNode(3);
        printa(l1);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        addTwoNumbers(l1,l2);
        printa(mergeTwoLists(l1,l2));







    }

    public static class test1 {

        public static int climbStairs(int n) {
            int result = 0;
            if (n<1){
                return  0;
            }
            if (n==1){
                result=1;
                return  result;
            }
            if (n==2){
                result=2;
                return  result;
            }
            int[] res = new int[n+1];
            res[1]=1;
            res[2]=2;
            for(int i=3;i<n;i++){
                res[i]= res[i-1]+res[i-2];

            }
            return res[n];

        }
        public static void main(String[] args) {
            System.out.println(climbStairs(5));

        }
    }
}
