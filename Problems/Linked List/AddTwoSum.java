public class ClassNameHere {
   static class Node{
      int val;
      Node next;

      public Node(int value){
         this.val = value;
      }
   }
   public static void main(String[] args) {
      Node n1 = new Node(1);
      Node n2 = new Node(9);
      Node n3 = new Node(7);
      Node n4 = new Node(8);
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      Node m1 = new Node(2);
      Node m2 = new Node(5);
      m1.next = m2;

      add(m1,n1);

   }

   public static Node add(Node m, Node n){
      int carry=0;
      int mod=0;
      Node x = new Node(0);
      Node head = x;
      while(m != null && n != null){
         carry = m.val + n.val+ carry;
         mod=carry%10;
         carry=carry/10;
         x.next = new Node(mod);
         m = m.next;
         n = n.next;
         x = x.next;
      }

      while(m != null){
         x.next = new Node(m.val+carry);
         carry=carry/10;
         m = m.next;
         x = x.next;
      }

      while(n != null){
         x.next = new Node(n.val+carry);
         carry=carry/10;
         n = n.next;
         x = x.next;
      }

      if(carry>0){
         x.next = new Node(carry);
      }

      return head.next;
   }
}
