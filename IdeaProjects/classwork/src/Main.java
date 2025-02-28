public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        /*  list.head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        list.head.next =second;
        second.next = third;
        */
        list.head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
/*list.deleteFromBeginning();
        list.deleteFromEnd();
        list.printList();
         */
        list.head.next = second;
        second.next = third;

        list.printList();
    }
}
