/** A link list without recursive constructor.*/
public class SLList<LochNess> {

    private class IntNode{
        public LochNess item;
        public IntNode next;

        public IntNode(LochNess i, IntNode res) {
            item = i;
            next = res;
        }

        public void addLast(LochNess x){
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
    private int size;

    public SLList(LochNess x){
        sentinel = new IntNode(null, new IntNode(x, null));
        size = 1;
    }

    /** creating an empty list*/
    public SLList(){
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public void addFirst(LochNess x){
        sentinel.next = new IntNode(x, sentinel.next);
        size ++;
    }

    public LochNess getFirst(){
        return sentinel.next.item;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void addLast(LochNess x){
        sentinel.addLast(x);
        size ++;
    }

    public void iterateAddLast(LochNess x){
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
