/*The DogLauncher class will "test drive" the dog class. */

public class DogLauncher {
    static void main() {
        Dog yrc = new Dog(15);
        yrc.makeNoise();

        Dog lhz = new Dog(23);
        System.out.println(Dog.maxDog(yrc, lhz));
    }
}
