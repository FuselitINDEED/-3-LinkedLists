/**
 * A generic singly linked list implementation.
 * Supports insertion/removal at both ends, searching,
 * removing the first occurrence of a value, and in-place reversal.
 *
 * @param <T> the type of elements stored in the list
 */
public class linkedLists<T> {

    /**
     * Node class represents a single element in the list.
     * Each node stores data and a reference to the next node.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;   // First node in the list
    private Node<T> tail;   // Last node in the list
    private int size;       // Number of elements in the list

    /**
     * Inserts a new node at the head (front) of the list.
     * Complexity: O(1)
     */
    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.next = head; // New node points to old head
        head = newNode;      // Update head

        if (tail == null) {
            tail = newNode;  // List was empty
        }

        size++;
    }

    /**
     * Inserts a new node at the tail (end) of the list.
     * Complexity: O(1)
     */
    public void insertAtTail(T data) {
        Node<T> newNode = new Node<>(data);

        if (tail == null) {
            // List is empty — head and tail become the new node
            head = tail = newNode;
        } else {
            tail.next = newNode; // Old tail points to new node
            tail = newNode;      // Update tail
        }

        size++;
    }

    /**
     * Removes and returns the element at the head of the list.
     * Complexity: O(1)
     */
    public T removeFromHead() {
        if (head == null) {
            return null; // List is empty
        }

        T value = head.data;
        head = head.next; // Move head forward

        if (head == null) {
            tail = null; // List became empty
        }

        size--;
        return value;
    }

    /**
     * Removes and returns the element at the tail of the list.
     * Complexity: O(n) because we must find the node before the tail.
     */
    public T removeFromTail() {
        if (head == null) {
            return null; // Empty list
        }

        if (head == tail) {
            // Only one element
            T value = head.data;
            head = tail = null;
            size--;
            return value;
        }

        // Find the node before the tail
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }

        T value = tail.data;
        tail = current;     // Update tail
        tail.next = null;   // Remove last node
        size--;

        return value;
    }

    /**
     * Searches for the first node containing the given data.
     * Returns true if found, false otherwise.
     * Complexity: O(n)
     */
    public boolean find(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Removes the first occurrence of the given data.
     * Returns true if removed, false if not found.
     * Complexity: O(n)
     */
    public boolean removeFirstOccurrence(T data) {
        if (head == null) {
            return false; // Empty list
        }

        // Special case: removing head
        if (head.data.equals(data)) {
            removeFromHead();
            return true;
        }

        Node<T> current = head;

        // Look for node before the one to remove
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                // Remove the node
                if (current.next == tail) {
                    tail = current; // Update tail if needed
                }
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false; // Not found
    }

    /**
     * BONUS: Reverses the linked list in-place.
     * Complexity: O(n)
     */
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        tail = head; // After reversing, old head becomes tail

        while (current != null) {
            Node<T> nextNode = current.next; // Save next
            current.next = prev;             // Reverse pointer
            prev = current;                  // Move prev forward
            current = nextNode;              // Move current forward
        }

        head = prev; // New head is the last non-null node
    }

    /**
     * Returns the number of elements in the list.
     * Complexity: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Prints the list contents for debugging.
     */
    public void printList() {
        Node<T> current = head;
        System.out.print("[ ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("]");
    }
}
