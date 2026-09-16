import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B <T> implements Deque61B<T>{

    private class Node{
        T item;
        Node front;
        Node back;

        public Node(){
            item = null;
            front = null;
            back = null;
        }

        public Node(T x){
            item = x;
            front = null;
            back = null;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque61B(){
        size = 0;
        sentinel = new Node();
        sentinel.back = sentinel;
        sentinel.front = sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node first = new Node(x);
        size += 1;

        // First's link
        first.front = sentinel;
        first.back = sentinel.back;

        // Sentinel'back's link
        sentinel.back.front = first;

        // Sentinel's link
        sentinel.back = first;
    }

    @Override
    public void addLast(T x) {
        Node last = new Node(x);
        size += 1;

        // set last's link
        last.front = sentinel.front;
        last.back = sentinel;

        // set sentinel's front
        sentinel.front.back = last;

        // set sentinel
        sentinel.front = last;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<T>();

        Node curr = sentinel.back;
        while(curr != sentinel){
            T Item = curr.item;
            returnList.addLast(Item);
            curr = curr.back;
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(!isEmpty()){
            T returnValue = sentinel.back.item;
            Node toBeEmpty = sentinel.back;
            // set sentinel
            sentinel.back = sentinel.back.back;
            sentinel.back.front = sentinel;
            // set EmptyNode
            toBeEmpty.front = null;
            toBeEmpty.back = null;

            size --;
            return returnValue;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if(!isEmpty()){
            Node toBeEmpty = sentinel.front;

            // set sentinel
            sentinel.front = toBeEmpty.front;
            toBeEmpty.front.back = sentinel;
            // set EmptyNode
            toBeEmpty.front = null;
            toBeEmpty.back = null;

            size --;
            return toBeEmpty.item;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < size()){
            Node curr = sentinel.back;
            int cnt = 0;
            while(cnt < index){
                curr = curr.back;
                cnt += 1;
            }
            return curr.item;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if(index >= 0 && index < size){
            return getRecursiveHelper(sentinel.back, index);
        }
        return null;
    }

    private T getRecursiveHelper(Node curr, int index){
        if(index == 0) return curr.item;
        else return getRecursiveHelper(curr.back, index - 1);
    }
}
