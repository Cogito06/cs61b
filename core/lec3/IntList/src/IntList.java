public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int get(int i){
        int cnt = 0;
        IntList curr = this;
        while (cnt < i && curr != null) {
            cnt ++;
            curr = curr.rest;
        }
        if(curr == null){
            throw new IndexOutOfBoundsException("Index Out Of Range.");
        }
        else{
            return curr.first;
        }
    }

    public int iterativeSize(){
        IntList p = this;
        int cnt = 0;
        while(p != null) {
            cnt += 1;
            p = p.rest;
        }
        return cnt;
    }

    public int size(){
        int ans = 0;
        if (this.rest == null){
            ans = 1;
        }
        else{
            ans = 1 + this.rest.size();
        }
        return ans;
    }

    static void main(String[] args) {
        /*
        IntList L = new IntList();
        L.first = 5;
        L.rest = null;

        L.rest = new IntList();
        L.rest.first = 10;

        L.rest.rest = new IntList();
        L.rest.rest.first = 15;
        */

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.iterativeSize());

        /* test get function*/
        System.out.println(L.get(0));
        System.out.println(L.get(2));
        System.out.println(L.get(5));
    }
}
