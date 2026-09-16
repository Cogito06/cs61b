public class HofDemo {
    public static int doTwice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    static void main(String[] args) {
        IntUnaryFunction tenX = new TenX();
        System.out.println(doTwice(tenX, 2));
    }
}
