/** A link list without recursive constructor.*/
public class SLList {

    private static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode res) {
            item = i;
            next = res;
        }

        public void addLast(int x){
            if(next == null){
                next = new IntNode(x, null);
            }
            else {
                this.next.addLast(x);
            }
        }

        public int size(){
            if(this.next == null) return 1;
            else return (1 + this.next.size());
        }
    }
    private IntNode first;
    public int size;

    public SLList(int x){
        first = new IntNode(x, null);
        size = 1;
    }

    /** creating an empty list*/
    public SLList(){
        first = null;
        size = 0;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
        size ++;
    }

    public int getFirst(){
        return first.item;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void addLast(int x){
        if(this.isEmpty()) {
            first = new IntNode(x, null);
        }
        else {
            if (first.next == null) {
                first.next = new IntNode(x, null);
            } else {
                first.next.addLast(x);
            }
        }
        size ++;
    }

    public void iterateAddLast(int x){
        if(isEmpty()){
            first = new IntNode(x, null);
        }
        else {
            IntNode curr = first;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new IntNode(x, null);
        }
        size ++;
    }

    public int size(){
        return first.size();
    }

    public int iterateSize(){
        int totLen = 1;
        IntNode curr = first;
        while(curr.next != null){
            totLen += 1;
            curr = curr.next;
        }
        return totLen;
    }

    public int fastSize(){
        return this.size;
    }
}
