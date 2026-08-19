public class Dessert {
    int flavor;
    int price;
    static int numDesserts;

    public Dessert(int flavor, int price){
        this.flavor = flavor;
        this.price = price;
        numDesserts ++;
    }

    public void printDessert(){
        System.out.println(flavor + " " + price + " " + numDesserts);
    }

    static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
