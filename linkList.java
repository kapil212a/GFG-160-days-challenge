//import org.w3c.dom.Node;
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

    }
}

