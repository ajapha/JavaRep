package linked;

public class Linked {
    public static void main(String[] args) {
        /*Node<String> node = new Node<String>();
        node.setData("Hello");
        
        Node<String> node2 = new Node<String>();
        node2.setData("Goodbye");
        
        Node<String> node3 = new Node<String>();
        node3.setData("Hello Again");
        
        node.setNext(node2);
        node2.setNext(node3);
        
        Node<String> node4 = new Node<String>();
        node4.setData("In middle");
        
        node.setNext(node4);
        node4.setNext(node2);*/
        
        LinkedList<String> list = new LinkedList<String>();
        list.add("Hello");
        list.add("Goodbye");
        list.add("Hello Again");
        list.add("In middle", 1);
        list.add("New Begining", 0);
        
        list.add("New end", 10);
    }
}
