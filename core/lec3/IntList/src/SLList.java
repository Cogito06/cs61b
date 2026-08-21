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
    private IntNode sentinel;
    public int size;
    public static int defaultValue = 20071008;

    public SLList(int x){
        sentinel = new IntNode(defaultValue, new IntNode(x, null));
        size = 1;
    }

    /** creating an empty list*/
    public SLList(){
        sentinel = new IntNode(defaultValue, null);
        size = 0;
    }

    public void addFirst(int x){
        sentinel = new IntNode(defaultValue, new IntNode(x, sentinel.next));
        size ++;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void addLast(int x){
        sentinel.addLast(x);
        size ++;
    }

    public void iterateAddLast(int x){
        IntNode curr = sentinel;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new IntNode(x, null);
        size ++;
    }

    public int size(){
        return sentinel.size() - 1;
    }

    public int iterateSize(){
        int totLen = 0;
        IntNode curr = sentinel;
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
