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

    public static Dog maxDog(Dog d1, Dog d2){
        if(d1.weightInPounds > d2.weightInPounds)
            return d1;
        else return d2;
    }

    public Dog maxDog(Dog d2){
        if(this.weightInPounds > d2.weightInPounds) return this;
        else return d2;
    }
}
