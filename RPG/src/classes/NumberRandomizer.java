package classes;

import java.util.Random;

public class NumberRandomizer {
    int newNumber;
    int oldNumber = -1;
    public NumberRandomizer() {

        Random random = new Random();

        for(int i=0;i<1;i++){
            do{
                newNumber = random.nextInt(80);
            } while (newNumber == oldNumber);
            oldNumber = newNumber;
        }

    }

    public int randomizedNumber() {
        Random random = new Random();

        for(int i=0;i<1;i++){
            do{
                newNumber = random.nextInt(80);
            } while (newNumber == oldNumber);
            oldNumber = newNumber;
        }
        return newNumber;
    }
}
