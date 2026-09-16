public interface List<Item> {
    public int size();
    public Item get(int index);
    public Item getLast();
    public Item getFirst();
    public Item removeLast();
    public void addFirst(Item x);
    public void addLast(Item x);
    public void insert(int i, Item x);

    default public void print(){
        for(int i = 0; i < size(); i ++){
            System.out.println(get(i) + " ");
        }
        System.out.println();
    }
}
