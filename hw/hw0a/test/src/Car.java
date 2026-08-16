import java.net.SocketOption;

public class Car {
    public String model;
    public int gas;

    public Car(String m){
        model = m;
        gas = 5;
    }

    public void drive(){
        if(gas < 5){
            System.out.println("Cannot drive");
            return ;
        }

        gas -= 5;
        System.out.println(model + "goes vroom!");
    }

    public int gasLeft(){
        return gas;
    }

    public void addGas(int amount){
        gas += amount;
    }

    public static void main(String[] args){
        Car c1, c2;
        c1 = new Car("Yrc");
        c2 = new Car("Bench");

        System.out.println(c1.gasLeft());
        c1.drive();
        System.out.println(c1.gasLeft());

        c1.addGas(1);
        System.out.println(c1.gasLeft());
        c1.drive();

        System.out.println(c2.gasLeft());

    }
}