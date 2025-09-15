//import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


public  class linkList {
    static Node reverseList(Node head) {
        
        Node temp = head , prev = null , next;
        
        while(temp != null){
            next = temp.next;
            
            temp.next = prev;
            
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static Node rotate(Node head, int k) {
        
        if(k==0 ||  head == null){
            return head;
        }
        Node temp = head;
        for(int i = 0; i<k; ++i){
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = head;
            temp = temp.next;
            head = head.next;
            temp.next = null;
        }
        return head;
    }

     public static Node sortedMerge(Node head1, Node head2) {
        
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                curr.next = head1;
                head1 = head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if(head1 != null){
            curr.next = head1;
        }else{
            curr.next = head2;
        }
        return dummy.next;
    }

    public static Node reverseKGroup(Node head, int k) {
        
        if(head == null && k == 1){
            return head;
        }
        Stack <Node> st = new Stack<>();
        Node temp = head;
        Node prev = null;
        
        while(temp != null){
            int count = 0;
            while(temp != null && count < k){
                st.push(temp);
                temp = temp.next;
                count++;
            }
            while(!st.isEmpty()){
                if(prev == null){
                    prev = st.pop();
                    head = prev;
                }else{
                    prev.next = st.pop();
                    prev = prev.next;
                    
                }
            }
        }
        prev.next = null;
        return head;
}

    public static Node reverse(Node head){
        Node temp = head , prev = null , next = null;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    
    
    public static Node addTwoLists(Node head1, Node head2) {
        
        head1 = reverse(head1);
        head2 = reverse(head2);
        
        Node sum = null;
        int carry = 0;
        while(head1 != null || head2 != null || carry >0){
            int newVal = carry;
            if(head1 != null){
                newVal += head1.data;
                head1 = head1.next;
            }
            if(head2 != null){
                newVal += head2.data;
                head2 = head2.next;
            }
            carry = newVal/10;
            newVal %= 10;
            
            Node newNode = new Node(newVal);
            newNode.next = sum;
            sum = newNode;
        }
        while(sum != null && sum.data == 0){
            sum = sum.next;
        }
        return (sum == null) ? new Node(0) : sum;
    }

    public static Node cloneLinkedList(Node head) {
        
        Map<Node , Node> mp = new HashMap<>();
        
        Node curr = head;
        while(curr != null){
            mp.put(curr , new Node(curr.data));
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null){
            Node newNode = mp.get(curr);
            newNode.next = mp.get(curr.next);
            
            newNode.random = mp.get(curr.random);
            curr = curr.next;
        }
        return mp.get(head);
    }

    public static void printll(Node node){  
        while(node != null){
            System.out.print(node.data + "-->");
            node = node.next;
            
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head = reverseList(head);
        printll(head);

        head = rotate(head, 04);
        printll(head);

        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node res = sortedMerge(head1, head2);
        printll(res);

        head = reverseKGroup(head, 2);
        printll(head);

        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);

        Node sum = addTwoLists(num1, num2);
        printll(sum);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        System.out.println("Original linked list:");
        printll(head);
  
        Node clonedList = cloneLinkedList(head);
  
        System.out.println("Cloned linked list:");
        printList(clonedList);

    }
}

