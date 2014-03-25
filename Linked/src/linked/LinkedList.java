package linked;

public class LinkedList<T> {
    private Node<T> head;
    
    // Add a new item to end of list
    public void add(T item) {
        // create new node to hold item
        Node<T> node = new Node<T>();
        node.setData(item);
        
        // special case - first item in list
        if (head == null) {
            head = node;
        } else { // not first item
            // walk list until last item. Add new node at end
            Node temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }
    
    // add item at a specific point in list
    public void add(T item, int index) {
        // create new node to hold item
        Node<T> newNode = new Node<T>();
        newNode.setData(item);
        
        // special case. New first item
        if (index == 0) {
            Node oldHead = head;
            head = newNode;
            newNode.setNext(oldHead);
        } else { // not first item. Need to walk items until
                 // correct spot and the add node. May need
                 // to create "empty" nodes along the way
                 // if nodes dont exist all the way to the desired
                 // index
            
            // Make sure we have a head or create an empty one
            if (head == null) {
                head = new Node<T>();
            }
            // loop through nodes until desired index
            Node next = head;
            for (int i = 0; i < index - 1; i++) {
                Node temp = next.getNext();
                // create an empty node if needed
                if (temp == null) {
                    temp = new Node<T>();
                    next.setNext(temp);
                }
                next = temp;
            }
            // We got to desired index, now add new node
            Node oldNext = next.getNext();
            next.setNext(newNode);
            newNode.setNext(oldNext);
        }
    }
}
