import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        Random rand = new Random();
        int nBalls = 10;
        int test = 100;
        //int[] pos = {200,200};
        //int[] pos2 = {475,400};
        //Ball ball1 = new Ball(0,pos, 50, rand.nextDouble()*2*Math.PI, 10, Color.GREEN);
        //Ball ball2 = new Ball(1,pos2, 25, rand.nextDouble()*2*Math.PI, 10, Color.BLUE);

        int[][] positions = {{50,50}, {100,550},{150,150},{200,250},{250,250},{300,350},{350,350},{400,750},{450,450},{500,550}};
        //Ball[] balls = {ball1, ball2};
        List<Ball> ballList = new ArrayList<Ball>();
        for(int i = 0; i <nBalls; i++) {
            ballList.add(new Ball(i, positions[i], 25, rand.nextDouble() * 2 * Math.PI, 5, Color.getHSBColor(rand.nextFloat()*360, 100, 100)));
        }

        MyFrame frame1 = new MyFrame();

        Thread thread0 = new Thread(new computeBall(ballList, frame1, 0));
        Thread thread1 = new Thread(new computeBall(ballList, frame1, 1));
        Thread thread2 = new Thread(new computeBall(ballList, frame1, 2));



        ArrayList<int[]> currentPos = new ArrayList<int[]>();
        ArrayList<Integer> radiuses = new ArrayList<Integer>();
        ArrayList<Color> colors = new ArrayList<Color>();
        for (Ball b: ballList) {
            currentPos.add(b.getPosition());
            radiuses.add(b.getRadius());
            colors.add(b.getColor());
        }
//        int[] radiuses = {ball1.getRadius(),ball2.getRadius()};
//        Color[] colors = {ball1.getColor(), ball2.getColor()};
        //colors[0] = ball1.getColor();
        //colors[1] = ball2.getColor();

        frame1.setBallsRadiuses(radiuses);
        frame1.setBallsColors(colors);
        frame1.setBallPositions(currentPos);
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            for (int i = 0; i < currentPos.size(); i++){
                currentPos.set(i,ballList.get(i).getPosition());//to jest potrzebne
            }

            //System.out.println("Nowa pozycja ball 1: "+ball1.getPosition()[0]+" "+ball1.getPosition()[1]);
            //System.out.println("Nowa pozycja ball 2: "+ball2.getPosition()[0]+" "+ball2.getPosition()[1]);

            frame1.repaint();

            //thread2.notifyAll();
            thread0.interrupt();
            thread1.interrupt();
            thread2.interrupt();

        }


    }
//    public synchronized void run(Ball[] balls, MyFrame frame1, int threadId){
//        balls[threadId].calculateNextPosition();
//        if(balls[threadId].collisionWithWall(frame1)) {
//            balls[threadId].changeDirectionAfterCollision(frame1);
//            balls[threadId].calculateNextPosition();
//        }
//        int id = balls[threadId].collisionWithBalls(balls);
//        if(id != -1){
//            balls[threadId].changeDirectionAfterCollision(frame1);
//            balls[threadId].calculateNextPosition();
//            balls[id].changeDirectionAfterCollision(frame1);
//            balls[id].calculateNextPosition();
//        }
//        balls[threadId].setPosition(balls[threadId].getNextPosition());
//        try {
//            wait();
//        }
//        catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//            // zrób coś po wybudzeniu
//        }
//    }
}



// TODO
// ranodmowy kierunek
// poruszanie sie pilek
// wykrywanie kolizji
// watki
