import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello from Main!");
        Random rand = new Random();

        int[] pos = {250,250};
        int[] pos2 = {400,400};
        Ball ball1 = new Ball(1,pos, 50, rand.nextDouble()*2*Math.PI, 300, Color.GREEN);
        Ball ball2 = new Ball(2,pos2, 25, rand.nextDouble()*2*Math.PI, 300, Color.BLUE);
        Math.cos(2*Math.PI);

//        System.out.println("ballsCollors:"+colors[0]+" "+colors[1]);

        MyFrame frame1 = new MyFrame();
        int[][] currentPos = {ball1.getPosition(),ball2.getPosition()};
        int[] radiuses = {ball1.getRadius(),ball2.getRadius()};
        Color[] colors = {ball1.getColor(), ball2.getColor()};
        colors[0] = ball1.getColor();
        colors[1] = ball2.getColor();

        frame1.setBallsRadiuses(radiuses);
        frame1.setBallsColors(colors);
        frame1.setBallPositions(currentPos);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ball1.calculateNextPosition();
        ball2.calculateNextPosition();
        System.out.println("Nowa pozycja ball 1: "+ball1.getPosition()[0]+" "+ball1.getPosition()[1]);
        frame1.setBallPositions(currentPos);
        frame1.repaint();

    }
}

// TODO
// ranodmowy kierunek
// poruszanie sie pilek
// wykrywanie kolizji
// watki
