public class DogProblem {
    public static Dog[] largerThanFourNeighbours(Dog[] dogs){
        Dog[] resDogs = new Dog[dogs.length];
        int cnt = 0;

        for(int i = 0; i < dogs.length; i ++){
            if(isLargerThanFourNeighbours(dogs, i)){
                resDogs[cnt] = dogs[i];
                cnt ++;
            }
        }

        resDogs = removeNull(resDogs, cnt);
        return resDogs;
    }

    /** Judge if the indexth element is isLargerThanFourNeighbours*/
    public static boolean isLargerThanFourNeighbours(Dog[] dogs, int index){
        /* we need to judge A 'all' problem*/
        boolean flag = true;
        for (int j = -2; j <= 2; j ++){
            /* we dont judge the same element*/
            if(j == 0){
                continue;
            }

            int currIndex = index + j;
            if(isLegalIndex(dogs, currIndex)){
                if(dogs[currIndex].weightInPounds > dogs[index].weightInPounds){
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static boolean isLegalIndex(Dog[] dogs, int index){
        return (index >= 0) && (index < dogs.length);
    }
    /** Remove the null elements in dogs array.*/
    public static Dog[] removeNull(Dog[] dogs, int length){
        Dog[] resDogs = new Dog[length];
        System.arraycopy(dogs, 0, resDogs, 0, length);
        return resDogs;
    }

    static void main() {
        Dog Dogs[] = new Dog[]{
                new Dog(10),
                new Dog(20),
                new Dog(30),
                new Dog(25),
                new Dog(20),
                new Dog(40),
                new Dog(10),
        };

        Dog[] resDogs = DogProblem.largerThanFourNeighbours(Dogs);

        for (Dog resDog : resDogs) {
            System.out.println(resDog.weightInPounds);
        }
    }
}
