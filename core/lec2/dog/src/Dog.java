public class Dog {
    int weightInPounds;

    public Dog(int w){
        weightInPounds = w;
    }

    void makeNoise(){
        if(weightInPounds < 10){
            System.out.println("Yip.");
        } else if (weightInPounds < 20) {
            System.out.println("Bark!");
        }else{
            System.out.println("Woooooooof!");
        }

    }
}
