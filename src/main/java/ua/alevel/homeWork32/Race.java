package ua.alevel.homeWork32;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {
    Scanner scanner = new Scanner(System.in);

    Horse firstHorse = new Horse(1);
    Horse secondHorse = new Horse(2);
    Horse thirdHorse = new Horse(3);
    Horse fourthHorse = new Horse(4);
    Horse fifthHorse = new Horse(5);

    static List<Integer> finishList = new ArrayList<>();

    public void startRace() throws InterruptedException {
        int usersNumber = askHorseNumber();
        Thread horse1 = new Thread(firstHorse);
        Thread horse2 = new Thread(secondHorse);
        Thread horse3 = new Thread(thirdHorse);
        Thread horse4 = new Thread(fourthHorse);
        Thread horse5 = new Thread(fifthHorse);
        horse1.start();
        horse2.start();
        horse3.start();
        horse4.start();
        horse5.start();
        Thread.currentThread().join(2000);
        findUsersHorse(usersNumber);
    }

    private int askHorseNumber(){
        System.out.println("We have 5 horses. Choose the number!");
        int usersNumber = scanner.nextInt();
        if(usersNumber <= 0 || usersNumber > 5){
            System.out.println("Choose the right number between 1 and 5!");
            System.exit(1);
        }
        return usersNumber;
    }

    private void findUsersHorse(int userNumber) {
        if ((finishList.indexOf(userNumber) + 1) == 1) {
            System.out.println("Congratulations!!! Your horse take a 1st place");
        } else {
            System.out.println("Try again, your horse take a " + (finishList.indexOf(userNumber)+1) + " place");
        }
    }

}
