import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

class Node {                              //Structure of Node
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}


public  class linkList {
    static Node reverseList(Node head) {                             //Reverse a linkled list 
        
        Node temp = head , prev = null , next;
        
        while(temp != null){
            next = temp.next;
            
            temp.next = prev;
            
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static Node rotate(Node head, int k) {                 //Rotate a linked list
        
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

     public static Node sortedMerge(Node head1, Node head2) {        ////merge sort
        
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

    public static Node reverseKGroup(Node head, int k) {              //reverse the group node
        
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

    public static Node reverse(Node head){              //// reverse the linklist
        Node temp = head , prev = null , next = null;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    
    
    public static Node addTwoLists(Node head1, Node head2) {          // add two linkedList in One
        
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

    public static Node cloneLinkedList(Node head) {                  //Make The Clone of linklist
        
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

    static void printList(Node head) {                       //Print The Link List
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null)
                System.out.print(head.random.data + ")");
            else 
                System.out.print("null" + ")");
        
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static boolean detectLoop(Node head) {              //Detect The Loop In  Linkedlist
        Node slow = head , fast = head;
        
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static int cycleStart(Node head) {                    //Remove Cycle From Linked List
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
            
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }
        return -1;
    }

    public static void removeLoop(Node head) {              //Remove Loop from linkedlist
        
        Node prev = null;
        HashSet <Node> st = new HashSet<>();
        while(head != null){
            if(!st.contains(head)){
                st.add(head);
                prev = head;
                head = head.next;
            }else{
                prev.next = null;
                break;
            }
        }
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

        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        head3.next.next.next.next = new Node(5);
        head3.random = head3.next.next;
        head3.next.random = head3;
        head3.next.next.random = head3.next.next.next.next;
        head3.next.next.next.random = head3.next.next;
        head3.next.next.next.next.random = head3.next;

        System.out.println("Original linked list:");
        printll(head3);
  
        Node clonedList = cloneLinkedList(head3);
  
        System.out.println("Cloned linked list:");
        printList(clonedList);

        System.out.println(detectLoop(head1));

        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(3);
        head4.next.next.next = new Node(4);
        head4.next.next.next.next = new Node(5);
        head4.next.next.next.next.next = new Node(6);

        head4.next.next.next.next.next = head4.next;
        System.out.println(cycleStart(head4));

        removeLoop(head4);
        printll(head4);

    }
}

