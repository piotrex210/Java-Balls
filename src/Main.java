import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int nBalls = 10;
        int test = 100;
        double[][] positions = {{600, 350}, {100, 550}, {150, 150}, {200, 250}, {250, 450}, {300, 350}, {350, 390}, {400, 750}, {450, 450}, {500, 550}};
        List<Ball> ballList = new ArrayList<Ball>();
        for (int i = 0; i < nBalls; i++) {
            ballList.add(new Ball(i, positions[i], 25, rand.nextDouble() * 2 * Math.PI, 1, new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))));
        }
        MyFrame frame1 = new MyFrame();
        Thread thread0 = new Thread(new computeBall(ballList, frame1, 0));
        Thread thread1 = new Thread(new computeBall(ballList, frame1, 1));
        Thread thread2 = new Thread(new computeBall(ballList, frame1, 2));


        ArrayList<double[]> currentPos = new ArrayList<double[]>();
        ArrayList<Integer> radiuses = new ArrayList<Integer>();
        ArrayList<Color> colors = new ArrayList<Color>();
        for (Ball b : ballList) {
            currentPos.add(b.getPosition());
            radiuses.add(b.getRadius());
            colors.add(b.getColor());
        }

        frame1.setBallsRadiuses(radiuses);
        frame1.setBallsColors(colors);
        frame1.setBallPositions(currentPos);

        thread0.start();
        thread1.start();
        thread2.start();


        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < currentPos.size(); i++) {
                currentPos.set(i, ballList.get(i).getPosition());//to jest potrzebne
            }
            frame1.repaint();
            thread0.interrupt();
            thread1.interrupt();
            thread2.interrupt();
        }
    }
}

