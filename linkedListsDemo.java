public class linkedListsDemo {

    public static void main(String[] args) {

        linkedLists<Integer> list = new linkedLists<>();

        System.out.println("Inserting at head: 3, 2, 1");
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.printList();

        System.out.println("\nInserting at tail: 4, 5");
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.printList();

        System.out.println("\nRemoving from head...");
        list.removeFromHead();
        list.printList();

        System.out.println("\nRemoving from tail...");
        list.removeFromTail();
        list.printList();

        System.out.println("\nFinding value 3: " + list.find(3));
        System.out.println("Finding value 99: " + list.find(99));

        System.out.println("\nRemoving first occurrence of 3...");
        list.removeFirstOccurrence(3);
        list.printList();

        System.out.println("\nReversing list...");
        list.reverse();
        list.printList();

        System.out.println("\nFinal size: " + list.size());
    }
}
