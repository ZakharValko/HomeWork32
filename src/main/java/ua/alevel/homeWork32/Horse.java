package ua.alevel.homeWork32;

import static ua.alevel.homeWork32.Race.finishList;

public class Horse implements Runnable{

    private final int number;
    private final int minStep = 60;
    private final int maxStep = 100;
    private int distance = 1000;

    public int getDistance() {
        return distance;
    }

    public int getNumber() {
        return number;
    }

    public Horse(int number) {
        this.number = number;
    }

    @Override
    public synchronized void run() {
        while (distance > 0){
            double step = minStep + Math.random() * (maxStep - minStep);
            distance = distance - (int)step;
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Horse number " + number + " is finished");
        finishList.add(number);
    }
}
