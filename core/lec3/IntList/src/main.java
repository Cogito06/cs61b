public class main {
    static void main(String[] args) {
        SLList list = new SLList(15);
        list.addFirst(10);
        list.addFirst(5);
        System.out.println(list.getFirst());

        list.iterateAddLast(20);
        System.out.println(list.size());

    }
}
