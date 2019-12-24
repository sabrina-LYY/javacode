
class Node{
    public Node prev;
    public Node next;
    public int data;
    public Node(){
    }
}
public class LinkedList<T> {
    Node first;
    Node last;
    private int size;
    public LinkedList() {
    }
    public boolean add(int data){
        Node node = new Node();
        if(first==null){
            first = node;
            last = node;
            node.prev = null;
            node.next = null;
            node.data = data;
        }else{
            node.prev = last;//下一个关联上一个
            node.next = null;
            node.data = data;
            last.next = node;//上一个关联下一ge
            last = node;
        }
        size++;
        return true;
    }



}
